import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first, last } from 'rxjs';
import { Forums } from 'src/app/classes/forums';
import { Lastid } from 'src/app/classes/lastid';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { LastidService } from 'src/app/services/lastid.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  ngOnInit(): void {

  }
  constructor (private service: AuthenticationService, private profservice: ProfileserviceService, private lastidservice: LastidService, private router: Router) {

  }
  email!: string;
  pass!: string;
  firstName!: string;
  lastName!: string;
  emailup!: string;
  passup!: string;
  pass2ndup!: string;
  user: UserProfile = new UserProfile;
  lastids!: Lastid;


  setEmail(event: any){
    this.email = event.target.value;
    console.log(this.email);
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

  setEmailUp(event: any) {
    this.user.email = event.target.value;
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
    this.lastidservice.getlastid().subscribe((ids: Lastid) => {
      if (ids) {
      this.lastids = ids;
      this.user.userId = this.lastids.userid + 1;

    if (this.user.firstName && this.user.lastName && this.user.email && this.passup && this.pass2ndup && this.user.userDescription){
      if (this.passup === this.pass2ndup) {
        this.user.password = this.passup;
        this.user.premium = true;
        this.user.followingForums = [];
        this.profservice.newUser(this.user).subscribe((data: any) => {
          console.log(data);
          this.lastids.userid = this.lastids.userid + 1;
          this.lastidservice.updatelastid(this.lastids).subscribe((res: any) => {
            console.log(res);
            alert("Signed Up");
            this.router.navigateByUrl("/login");
          })
        })
      } else {
        alert("Entered Passwords doesn't match");
      }
    } else {
      alert("Enter all the fields");
    }
      } else {
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

    if (this.user.firstName && this.user.lastName && this.user.email && this.passup && this.pass2ndup && this.user.userDescription){
      if (this.passup === this.pass2ndup) {
        this.user.password = this.passup;
        this.user.premium = true;
        this.user.followingForums = [];
        this.profservice.newUser(this.user).subscribe((data: any) => {
          console.log(data);
          this.lastids.userid = this.lastids.userid + 1;
          this.lastidservice.updatelastid(this.lastids).subscribe((res: any) => {
            console.log(res);
            alert("Signed Up");
            this.ngOnInit();
            this.router.navigateByUrl("/login");
          })
        })
      } else {
        alert("Entered Passwords doesn't match");
      }
    } else {
      alert("Enter all the fields");
    }
      }
  })

  }

  login () {
    this.service.authenticate(this.email, this.pass);
  }

  // user!: UserProfile;
  hidePassword: boolean = true;

  togglePassword() {
    this.hidePassword = !this.hidePassword;
  }


}
