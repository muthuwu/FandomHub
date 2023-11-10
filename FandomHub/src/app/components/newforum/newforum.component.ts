import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Forums } from 'src/app/classes/forums';
import { Lastid } from 'src/app/classes/lastid';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { LastidService } from 'src/app/services/lastid.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-newforum',
  templateUrl: './newforum.component.html',
  styleUrls: ['./newforum.component.css']
})
export class NewforumComponent implements OnInit{
  ngOnInit(): void {

  }

  constructor (private router: Router, private service: ProfileserviceService, private lastidservice: LastidService, private authservice: AuthenticationService) {}

  forum: Forums = new Forums;
  lastid!: Lastid;
  user!: UserProfile;

  getName(event: any) {
    this.forum.forumtitle = event.target.value;
  }

  getDesc(event: any) {
    this.forum.forumdesc = event.target.value;
  }

  createForum() {
    if (this.forum.forumtitle && this.forum.forumdesc) {
      this.forum.posts = [];
      // this.forum.followers = new Set<number>();
      this.forum.followers = [];
      this.forum.ownerid = this.authservice.getUser().userId;
      this.lastidservice.getlastid().subscribe((data: Lastid) => {
        this.lastid = data;
        this.forum.forumid = this.lastid.forumid + 1;
        this.lastid.forumid = this.forum.forumid;
        this.service.addForum(this.forum).subscribe((data: any) => {
          console.log(data);
          this.lastidservice.postlastid(this.lastid).subscribe((data: any) => {
            console.log(data);
            alert("New Forum Created");
            this.router.navigateByUrl("/profile");
          })
        })
      })
    } else {
      alert("Enter all the details");
    }
  }
}
