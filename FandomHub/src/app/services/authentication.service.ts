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
  authenticate(email: string, password: string) {
    this.service.getUserAuth(email).subscribe((data: any) => {
      if (data) {
      this.user = data;
      console.log(this.user);
      this.wait(10000);
      if (this.user.email === email && this.user.password === password) {
        sessionStorage.setItem('email', email.toString());
        console.log("Good Login");
        this.router.navigateByUrl("/profile");
      } else {
        alert("Password Doesn't match");
        this.router.navigateByUrl("/login");
      }
    } else {
      alert("User doesn't exist");
    }
    })
  }

  getUser() {
    return this.user;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('email');
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('email');
    this.router.navigateByUrl("/login");
  }
}
