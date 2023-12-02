import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Forums } from 'src/app/classes/forums';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
    ngOnInit(): void {
      let id = this.authservice.getUser().userId;
      this.service.getUser(id).subscribe((data: UserProfile) => {
        this.user = data;
        console.log(data);
      })
      this.service.getMyforums(id).subscribe((data: Forums[]) => {
        this.forums = data;
        console.log(data);
      })
    }

    constructor (private service: ProfileserviceService, private authservice: AuthenticationService, private router: Router) {

    }

    goToMyForum(id: number) {
      this.router.navigateByUrl("/myforum/"+id);
    }

    user: UserProfile = new UserProfile();
    forums!: Forums[];


    createNewForum() {
      if (this.user.premium===true){
        this.router.navigateByUrl("/newforum");
      } else {
        if (this.forums.length>=5) {
          alert("Upgrade your account to be a premium user and create more than 5 forums!");
        } else {
          this.router.navigateByUrl("/newforum");
        }
      }
    }

    goToEditProfile() {
      this.router.navigateByUrl("/editprofile");
    }

    deleteAccount() {
      if(confirm("Are you sure to delete?")) {
      this.service.deleteUser(this.user.userId).subscribe((data: any) => {
        console.log(data);
        this.authservice.logOut();
      })
    }
    }

    upgradeAcc() {
      this.user.premium=true;
      this.service.updateUser(this.user).subscribe((data: any) => {
        console.log(data);
        this.ngOnInit();
      })
    }
}
