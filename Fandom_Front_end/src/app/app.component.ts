import { Component, HostListener, Input } from '@angular/core';
import { AuthenticationService } from './services/authentication.service';
import { Router } from '@angular/router';
import { FeedserviceService } from './services/feedservice.service';
import { Forums } from './classes/forums';
import { ProfileserviceService } from './services/profileservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FandomHub';
  activeItem: string | null = "Home";
  feedselected: boolean = false;
  myforumselected: boolean = false;
  profileselected: boolean = false;
  logoutselected: boolean = false;

  onItemClick(item: string) {
    this.activeItem = item;
  }

  constructor (private service: AuthenticationService, private router: Router, private profservice: ProfileserviceService) {}
  logout() {
    this.logoutselected = true;
    this.service.logOut();
  }

  islogged() {
    if (this.service.isUserLoggedIn()){
      return true;
    }
    return false;
  }

  feed() {
    this.feedselected = true;
    this.router.navigateByUrl("/feed");
  }

  profile() {
    this.profileselected = true;
    this.router.navigateByUrl("/profile");
  }

  myforums() {
    this.myforumselected = true;
    let userid = this.service.getUser().userId;
    this.profservice.getMyforums(userid).subscribe((data: Forums[]) => {
      this.router.navigateByUrl("/myforum/"+data[0].forumid);
    })
  }
 
  // @HostListener("window:beforeunload", ["$event"]) unloadHandler(event: Event) {
  //   let result = confirm("Refreshing will terminate your login.");
  //   if (result) {

  //   }
  //   event.returnValue = false; // stay on same page
  // }
}
