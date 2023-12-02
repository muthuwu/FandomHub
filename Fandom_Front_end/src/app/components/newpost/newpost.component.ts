import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Forums } from 'src/app/classes/forums';
import { Lastid } from 'src/app/classes/lastid';
import { Posts } from 'src/app/classes/posts';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { LastidService } from 'src/app/services/lastid.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-newpost',
  templateUrl: './newpost.component.html',
  styleUrls: ['./newpost.component.css']
})
export class NewpostComponent implements OnInit{
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.forumid = +params['id'];
  });
  }

  constructor (private router: Router, private service: ProfileserviceService, private lastidservice: LastidService, private authservice: AuthenticationService, private route: ActivatedRoute) {}

  forum!: Forums;
  lastid!: Lastid;
  user!: UserProfile;
  post: Posts = new Posts;
  forumid!: number;

  getTitle(event: any) {
    this.post.posttitle = event.target.value;
  }

  getContent(event: any) {
    this.post.postcontent = event.target.value;
  }

  createForum() {
    if (this.post.posttitle && this.post.postcontent) {
      this.post.comments = [];
      this.post.upvote = 0;
      this.post.ownerid = this.authservice.getUser().userId;
      this.post.forumid = this.forumid;
      this.lastidservice.getlastid().subscribe((data: Lastid) => {
        this.lastid = data;
        this.post.postid = this.lastid.postid + 1;
        this.lastid.postid = this.post.postid;

        this.service.addPost(this.post).subscribe((data: any) => {
          console.log(data);
          this.service.getForum(this.forumid).subscribe((data: any) => {
            this.forum = data;
            this.forum.posts.push(this.post.postid);
            this.service.updateForum(this.forum).subscribe((data: any) => {
              console.log(data);
              this.lastidservice.updatelastid(this.lastid).subscribe((data: any) => {
                console.log(data);
                alert("New Post Created");
                this.router.navigateByUrl("/myforum/"+this.forumid);
              })
            })
          })
        })
      })
    } else {
      alert("Enter all the details");
    }
  }

}
