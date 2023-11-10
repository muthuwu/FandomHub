import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  ngOnInit(): void {
    
  }
  activeItem: string | null = "Home";

  onItemClick(item: string) {
    this.activeItem = item;
  }

  constructor (private service: AuthenticationService, private router: Router) {}
  logout() {
    this.service.logOut();
  }

  islogged() {
    if (this.service.isUserLoggedIn()){
      return true;
    }
    return false;
  }

  feed() {
    this.router.navigateByUrl("/feed");
  }

  profile() {
    this.router.navigateByUrl("/profile");
  }

  @HostListener("window:beforeunload", ["$event"]) unloadHandler(event: Event) {
    let result = confirm("Refreshing will terminate your login.");
    if (result) {

    }
    event.returnValue = false; // stay on same page
  }
}
