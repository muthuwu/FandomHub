import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Otpbody } from 'src/app/classes/otpbody';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { OtpserviceService } from 'src/app/services/otpservice.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.css']
})
export class OtpComponent implements OnInit{
  ngOnInit(): void {
    this.userphonenumber=this.authservice.getUser().phonenumber;
    this.username=this.authservice.getUser().firstName;
    this.body.phoneNumber="+91"+this.userphonenumber.toString();
    this.body.username=this.username;
    this.service.getOtp(this.body).subscribe((data: any) => {
      console.log(data);
      this.origotp=data;
    })
  }
  constructor (private router: Router, private service: OtpserviceService, private authservice: AuthenticationService) {}

  otp!: string;
  userphonenumber!: number;
  username!: string;
  body: Otpbody = new Otpbody;
  origotp!: string;

  enterOtp(event: any) {
    this.otp = event.target.value;
  }

  verifyMobileOTP(): void {
    // Your verification logic here
    if (this.origotp===this.otp) {
      this.authservice.login(this.userphonenumber);
      this.router.navigateByUrl("/profile");
    } else {
      alert("Wrong OTP");
      this.router.navigateByUrl("/login");
    }
    console.log('Entered OTP:', this.otp);

    // Add your further verification logic or API call here
  }
}
