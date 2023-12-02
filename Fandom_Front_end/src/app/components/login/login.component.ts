import { Component, ElementRef, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Lastid } from 'src/app/classes/lastid';
import { Otpbody } from 'src/app/classes/otpbody';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { LastidService } from 'src/app/services/lastid.service';
import { OtpserviceService } from 'src/app/services/otpservice.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  ngOnInit(): void {

  }
  constructor (private service: AuthenticationService, private profservice: ProfileserviceService, private lastidservice: LastidService, private router: Router, private otpservice: OtpserviceService) {

  }
  phonenumber!: number;
  pass!: string;
  firstName!: string;
  lastName!: string;
  passup!: string;
  pass2ndup!: string;
  user: UserProfile = new UserProfile;
  lastids!: Lastid;
  otp!: string;
  origotp!: string;
  body: Otpbody = new Otpbody;


  setPhonenumber(event: any){
    this.phonenumber = event.target.value;
    console.log(this.phonenumber);
  }

  setPass(event: any){
    this.pass = event.target.value;
    console.log(this.pass);
  }

  setFirstNameUp(event: any) {
    this.user.firstName = event.target.value;
  }

  setLastNameUp(event: any) {
    this.user.lastName = event.target.value;
  }

  setPhonenumberUp(event: any) {
    this.user.phonenumber = event.target.value;
  }

  setPassUp(event: any) {
    this.passup = event.target.value;
  }

  set2ndPassUp(event: any) {
    this.pass2ndup = event.target.value;
  }

  setUserDescUp(event: any) {
    this.user.userDescription = event.target.value;
  }

  signup() {
        this.profservice.newUser(this.user).subscribe((data: any) => {
          console.log(data);
          this.lastids.userid = this.lastids.userid + 1;
          this.lastidservice.updatelastid(this.lastids).subscribe((res: any) => {
            console.log(res);
            alert("Signed Up");
            this.service.signup(this.user.phonenumber);
          })
        })
  }

  login () {
    this.service.authenticate(this.phonenumber, this.pass);
  }

  // user!: UserProfile;
  hidePassword: boolean = true;

  togglePassword() {
    this.hidePassword = !this.hidePassword;
  }

  enterOtp(event: any) {
    this.otp = event.target.value;
  }

  otpvisibility: boolean = false;

  register() {
    try{
        this.lastidservice.getlastid().subscribe((ids: Lastid) => {
            this.lastids = ids;
            this.user.userId = this.lastids.userid + 1;

          if (this.user.firstName && this.user.lastName && this.user.phonenumber && this.passup && this.pass2ndup && this.user.userDescription){
            if (this.passup === this.pass2ndup) {
              this.user.password = this.passup;
              this.user.premium = false;
              this.user.followingForums = [];
              this.otpvisibility=true;
              this.body.username=this.user.firstName;
              this.body.phoneNumber="+91"+this.user.phonenumber.toString();
              this.otpservice.getOtp(this.body).subscribe((data: any) => {
                console.log(data);
                this.origotp=data;
              })
            } else {
              alert("Entered Passwords doesn't match");
            }
          } else {
            alert("Enter all the fields");
          }

  })
} catch(e) {
  let lastid: Lastid = new Lastid();
              lastid.id = 1;
              lastid.userid = 0;
              lastid.forumid = 0;
              lastid.postid = 0;
              lastid.commentid = 0;
              this.lastidservice.createlastid(lastid).subscribe((data: any) => {
                console.log(data);
              })
              this.lastids = lastid;
              this.user.userId = this.lastids.userid + 1;

          if (this.user.firstName && this.user.lastName && this.user.phonenumber && this.passup && this.pass2ndup && this.user.userDescription){
            if (this.passup === this.pass2ndup) {
              this.user.password = this.passup;
              this.user.premium = false;
              this.user.followingForums = [];
              this.otpvisibility=true;
              this.body.username=this.user.firstName;
              this.body.phoneNumber="+91"+this.user.phonenumber.toString();
              this.otpservice.getOtp(this.body).subscribe((data: any) => {
                console.log(data);
                this.origotp=data;
              })
            } else {
              alert("Entered Passwords doesn't match");
            }
          } else {
            alert("Enter all the fields");
          }
}
  }

  verifyMobileOtp() {
    if (this.origotp===this.otp) {
      this.signup();
    } else {
      alert("Wrong OTP");
      this.router.navigateByUrl("/login");
    }
  }
}
