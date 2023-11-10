import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Forums } from 'src/app/classes/forums';
import { Posts } from 'src/app/classes/posts';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { FeedserviceService } from 'src/app/services/feedservice.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-myforum',
  templateUrl: './myforum.component.html',
  styleUrls: ['./myforum.component.css']
})
export class MyforumComponent implements OnInit{
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = +params['id'];
  });
  this.profservice.getForum(this.id).subscribe((data: any) => {
    this.forum = data;
  });
  let usid = this.authservice.getUser().userId;
    this.feedservice.getForumPosts(this.id).subscribe((data: any) => {
      this.posts = data;
    });
    this.profservice.getMyforums(usid).subscribe((data: Forums[]) => {
      this.forums = data;
      console.log(data);
    })
  }

  goToMyForum(forumid: number) {
    // this.router.navigateByUrl("/myforum/"+forumid);
    console.log(forumid);

    this.feedservice.getForumPosts(forumid).subscribe((data: any) => {
      this.posts = data;
    });
    this.profservice.getForum(forumid).subscribe((data: any) => {
      this.forum = data;
    });
  }

  constructor(private feedservice: FeedserviceService, private profservice: ProfileserviceService, private authservice: AuthenticationService, private router: Router, private route: ActivatedRoute) {

  }
  id!: number;
  forums!: Forums[];
  posts!: Posts[];
  upvotes!: number;
  forum: Forums = new Forums;

  createPost(forumid: number) {
    this.router.navigateByUrl("/newpost/"+forumid);
}
}
