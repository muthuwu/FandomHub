import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Comments } from 'src/app/classes/comments';
import { Forums } from 'src/app/classes/forums';
import { Lastid } from 'src/app/classes/lastid';
import { Posts } from 'src/app/classes/posts';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { FeedserviceService } from 'src/app/services/feedservice.service';
import { LastidService } from 'src/app/services/lastid.service';
import { MyforumserviceService } from 'src/app/services/myforumservice.service';
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
    this.ui = this.forum.ui;
    this.setui();
    this.ui = this.forum.ui;
  });
  let usid = this.authservice.getUser().userId;
    this.feedservice.getForumPosts(this.id).subscribe((data: any) => {
      this.posts = data;
      this.posts.forEach((post) => {
        this.feedservice.getPostComments(post.postid).subscribe((data: Comments[]) => {
          this.comments[post.postid] = data as Comments[];
          this.commenttoggle[post.postid] = false;
          data.forEach((comment) => {
            this.userservice.getUser(comment.commenterid).subscribe((commenter: UserProfile) => {
              this.commenternames[comment.commentid]=commenter.firstName;
            })
          })
          console.log(data);
        })
      })
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
      this.posts.forEach((post) => {
        this.feedservice.getPostComments(post.postid).subscribe((data: Comments[]) => {
          this.comments[post.postid] = data as Comments[];
          this.commenttoggle[post.postid] = false;
          data.forEach((comment) => {
            this.userservice.getUser(comment.commenterid).subscribe((commenter: UserProfile) => {
              this.commenternames[comment.commentid]=commenter.firstName;
            })
          })
          console.log(data);
        })
      })
    });
    this.profservice.getForum(forumid).subscribe((data: any) => {
      this.forum = data;
      this.ui = this.forum.ui;
      this.setui();
    });
  }
  goToMySearchedForum(event: any) {
    this.feedservice.getForumPosts(event.target.value).subscribe((data: any) => {
      this.posts = data;
      this.posts.forEach((post) => {
        this.feedservice.getPostComments(post.postid).subscribe((data: Comments[]) => {
          this.comments[post.postid] = data as Comments[];
          this.commenttoggle[post.postid] = false;
          data.forEach((comment) => {
            this.userservice.getUser(comment.commenterid).subscribe((commenter: UserProfile) => {
              this.commenternames[comment.commentid]=commenter.firstName;
            })
          })
          console.log(data);
        })
      })
    });
    this.profservice.getForum(event.target.value).subscribe((data: any) => {
      this.forum = data;
      this.ui = this.forum.ui;
      this.setui();
    });
  }

  constructor(private feedservice: FeedserviceService, private profservice: ProfileserviceService, private authservice: AuthenticationService, private router: Router, private route: ActivatedRoute, private myforumservice: MyforumserviceService, private lastidservice: LastidService, private userservice: ProfileserviceService) {

  }
  id!: number;
  ui!: number;
  bgcolor: string = "#fff";
  color: string = "black";
  fontfamily: string = "'Times New Roman'";
  forums!: Forums[];
  posts!: Posts[];
  upvotes!: number;
  forum: Forums = new Forums;
  comments: Comments[][] = [];
  commenttoggle: boolean[] = [];
  commenternames: string[] = [];

  createPost(forumid: number) {
    this.router.navigateByUrl("/newpost/"+forumid);
  }

  deleteForum(forumid: number) {
    if(confirm("Are you sure to delete?")) {
      this.myforumservice.deleteForum(forumid).subscribe((data: any) => {
        console.log(data);
        alert("Deleted the forum with id "+ forumid);
        this.ngOnInit();
      });
    }
  }

  deletePost(postid: number) {
    if(confirm("Are you sure to delete?")) {
      this.myforumservice.deletePost(postid).subscribe((data: any) => {
        alert(data);
        this.ngOnInit();
      })
    }
  }

  setui() {
    if (this.forum.ui == 1) {
      this.bgcolor = "#363062";
      this.fontfamily = "Consolas, Monaco, Lucida Console, Liberation Mono, DejaVu Sans Mono, Bitstream Vera Sans Mono, Courier New";
      this.color = "#9AD0C2";
    } else if (this.forum.ui == 2) {
      this.bgcolor = "orange";
      this.color = "brown";
      this.fontfamily = "'Creepster', cursive";
    } else if (this.forum.ui == 3) {
      this.bgcolor = "hotpink";
      this.color = "#DA0C81";
      this.fontfamily = "'Pacifico', cursive";
    } else {
      this.bgcolor = "#fff";
      this.color = "black";
      this.fontfamily = "'Times New Roman'";
    }
  }

  toggleCommentVisibility(postid: number) {
    this.commenttoggle[postid] = !this.commenttoggle[postid];
  }
}
