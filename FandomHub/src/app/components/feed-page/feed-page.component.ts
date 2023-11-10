import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Forums } from 'src/app/classes/forums';
import { Posts } from 'src/app/classes/posts';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { FeedserviceService } from 'src/app/services/feedservice.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-feed-page',
  templateUrl: './feed-page.component.html',
  styleUrls: ['./feed-page.component.css']
})
export class FeedPageComponent implements OnInit{
  ngOnInit(): void {
    this.user = this.authservice.getUser();
    this.service.getFollowingForums(this.user.userId).subscribe((data: any) => {
      this.forums = data;
      this.forum = this.forums[0];
      this.followVisibility = false;
      this.allforums = [];
      console.log(this.forums);
      this.service.getForumPosts(this.forum.forumid).subscribe((data: any) => {
        this.posts = data;
        this.posts = this.posts.sort((a, b) => b.upvote - a.upvote);
        console.log(data);
        this.feedservice.getAllForums().subscribe((data: Forums[]) => {
          data.forEach(allforum => {
            if (allforum.ownerid != this.user.userId) {
              this.allforums.push(allforum);
            }
          });
        })
      })
    })


  }
  constructor (private service: FeedserviceService, private authservice: AuthenticationService, private userservice: ProfileserviceService, private feedservice: FeedserviceService) {

  }


  activeItem: string | null = "Home";

  onItemClick(item: string) {
    this.activeItem = item;
  }
  forums!: Forums[];
  forum: Forums = new Forums;
  posts!: Posts[];
  upvotes!: number;
  forumid!: number;
  user!: UserProfile;
  allforums: Forums[] = [];
  followVisibility: boolean = false;

  getForum(id: number) {
    this.forumid = id;
    this.service.getForumPosts(id).subscribe((data: any) => {
      this.posts = data;
      this.posts = this.posts.sort((a, b) => b.upvote - a.upvote);
      console.log(data);
    })
    this.followVisibility = false;
    this.userservice.getForum(this.forumid).subscribe((data: Forums) => {
      this.forum = data;
    })
  }

  followForum(forum: Forums) {
    let forumnew: Forums = new Forums;
    forumnew = forum;
    forumnew.followers.push(this.user.userId);
    this.service.followNewForum(forumnew).subscribe((data: any) => {
      console.log(data);
      this.user.followingForums.push(forum.forumid);
      this.userservice.updateUser(this.user).subscribe((data: any) => {
        console.log(data);
        this.ngOnInit();
      })
    })
  }

  openNewForum(event: any) {
    console.log(event.target.value);
    this.forumid = event.target.value;
    this.service.getForumPosts(this.forumid).subscribe((data: any) => {
      this.posts = data;
      this.posts = this.posts.sort((a, b) => b.upvote - a.upvote);
      console.log(data);
    })
    this.userservice.getForum(this.forumid).subscribe((data: Forums) => {
      this.forum = data;
      this.followVisibility = true;
      data.followers.forEach(follower => {
        if (follower===this.user.userId) {
          this.followVisibility = false;
        }
      });
      return;
    })
  }

  wait(ms: number) {
    var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > ms){
      break;
      }
    }
  }
}
