import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditProfileComponent implements OnInit{
  ngOnInit(): void {
    this.user = this.authservice.getUser();
  }

  user!: UserProfile;
  email!: string;
  pass!: string;
  bio!: string;
  oldpass!: string;
  pass2nd!: string;
  firstName!: string;
  lastName!: string;
  constructor (private authservice: AuthenticationService, private router: Router, private service: ProfileserviceService) {}

  getFirstName(event: any) {
    this.firstName = event.target.value;
  }

  getLastName(event: any) {
    this.lastName = event.target.value;
  }

  getEmail(event: any) {
    this.email = event.target.value;
  }

  getBio (event: any) {
    this.bio = event.target.value;
  }

  getOldPass(event: any) {
    this.oldpass = event.target.value;
  }

  getPass(event: any) {
    this.pass = event.target.value;
  }

  get2ndPass(event: any) {
    this.pass2nd = event.target.value;
  }

  updateDetails(): boolean {
    if(this.oldpass != this.user.password) {
      alert("Your Old password is either not entered or wrong. Enter the right password.");
      return false;
    }
    if (this.firstName) {
      this.user.firstName = this.firstName;
    }
    if (this.lastName) {
      this.user.lastName = this.lastName;
    }
    if (this.email) {
      this.user.email = this.email;
    }
    if (this.bio) {
      this.user.userDescription = this.bio;
    }
    if (this.pass) {
    if (this.pass != this.pass2nd) {
      alert("Passwords Doesn't Match! Enter again.");
      return false;
    } else {
      this.user.password = this.pass;
    }
  }
    return true;
  }

  editProfile () {
    if (this.updateDetails()) {
    this.service.updateUser(this.user).subscribe((data: any) => {
      console.log(data);
      alert(data);
      this.router.navigateByUrl('/profile');
    })
  }
  }
}
