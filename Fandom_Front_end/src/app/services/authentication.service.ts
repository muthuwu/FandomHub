import { Injectable } from '@angular/core';
import { ProfileserviceService } from './profileservice.service';
import { Router } from '@angular/router';
import { UserProfile } from '../classes/user-profile';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private service: ProfileserviceService, private router: Router) { }

  wait(ms: number) {
    var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > ms){
      break;
      }
    }
  }

  user!: UserProfile;
  authenticate(phonenumber: number, password: string) {
    this.service.getUserAuth(phonenumber).subscribe((data: any) => {
      if (data) {
      this.user = data;
      console.log(this.user);
      this.wait(10000);
      if (this.user.password === password) {
        this.router.navigateByUrl("/otp");
      } else {
        alert("Password Doesn't match");
        this.router.navigateByUrl("/login");
      }
    } else {
      alert("User doesn't exist");
      this.router.navigateByUrl("/login");
    }
    })
  }

  getUser() {
    return this.user;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('phonenumber');
    return !(user === null)
  }

  login(phonenumber: number) {
    sessionStorage.setItem('phonenumber', phonenumber.toString());
    console.log("Good Login");
  }

  signup(phonenumber: number) {
    this.service.getUserAuth(phonenumber).subscribe((data: any) => {
      if (data) {
      this.user = data;
      console.log(this.user);
      sessionStorage.setItem('phonenumber', phonenumber.toString());
      console.log("Good Login");
      this.router.navigateByUrl("/profile");
    } else {
      alert("Error in user creation");
      this.router.navigateByUrl("/login");
    }
    })
  }

  logOut() {
    sessionStorage.removeItem('phonenumber');
    this.router.navigateByUrl("/login");
  }
}
