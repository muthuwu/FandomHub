import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Comments } from 'src/app/classes/comments';
import { Forums } from 'src/app/classes/forums';
import { Lastid } from 'src/app/classes/lastid';
import { Posts } from 'src/app/classes/posts';
import { UserProfile } from 'src/app/classes/user-profile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { FeedserviceService } from 'src/app/services/feedservice.service';
import { LastidService } from 'src/app/services/lastid.service';
import { ProfileserviceService } from 'src/app/services/profileservice.service';

@Component({
  selector: 'app-feed-page',
  templateUrl: './feed-page.component.html',
  styleUrls: ['./feed-page.component.css']
})
export class FeedPageComponent implements OnInit{
  ngOnInit(): void {
    this.user = this.authservice.getUser();
    this.allforums = [];
    this.feedservice.getAllForums().subscribe((data: Forums[]) => {
      data.forEach(allforum => {
        if (allforum.ownerid != this.user.userId) {
          this.allforums.push(allforum);
        }
      });
    })
    this.service.getFollowingForums(this.user.userId).subscribe((data: Forums[]) => {

      this.forums = data;
      this.forum = this.forums[0];
      this.ui = this.forum.ui;
      this.setui();
      this.followVisibility = false;
      console.log(this.forums);
      if (this.forum) {
      this.service.getForumPosts(this.forum.forumid).subscribe((data: any) => {
        this.posts = data;
        this.posts = this.posts.sort((a, b) => b.upvote - a.upvote);
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
        console.log(data);

      })
    }
    })


  }
  constructor (private service: FeedserviceService, private authservice: AuthenticationService, private userservice: ProfileserviceService, private feedservice: FeedserviceService, private lastidservice: LastidService) {

  }


  activeItem: string | null = "Home";

  onItemClick(item: string) {
    this.activeItem = item;
  }
  forums!: Forums[];
  forum: Forums = new Forums;
  ui!: number;
  fontfamily: string = "'Times New Roman'";
  bgcolor: string = "#fff";
  color: string = "blue";
  posts!: Posts[];
  upvotes!: number;
  forumid!: number;
  user!: UserProfile;
  allforums: Forums[] = [];
  comments: Comments[][] = [];
  commenttoggle: boolean[] = [];
  commenternames: string[] = [];
  followVisibility: boolean = false;
  newcommentcontent!: string;
  newcomment: Comments = new Comments;

  getForum(id: number) {
    this.forumid = id;
    this.service.getForumPosts(id).subscribe((data: any) => {
      this.posts = data;
      this.posts = this.posts.sort((a, b) => b.upvote - a.upvote);
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
      console.log(data);
    })
    this.followVisibility = false;
    this.userservice.getForum(this.forumid).subscribe((data: Forums) => {
      this.forum = data;
      this.ui = this.forum.ui;
      this.setui();
    })
  }

  followForum(forum: Forums) {
    let forumnew: Forums = new Forums;
    forumnew = forum;
    forumnew.followers.push(this.user.userId);
    this.service.followUnfollowForum(forumnew).subscribe((data: any) => {
      console.log(data);
      this.user.followingForums.push(forum.forumid);
      this.userservice.updateUser(this.user).subscribe((data: any) => {
        console.log(data);
        this.ngOnInit();
      })
    })
  }

  unfollowForum(forum: Forums) {
    let forumnew: Forums = new Forums;
    forumnew = forum;
    const index = forumnew.followers.indexOf(this.user.userId);
    if (index > -1) {
      forumnew.followers.splice(index, 1);
    }
    this.service.followUnfollowForum(forumnew).subscribe((data: any) => {
      console.log(data);
      const index2 = this.user.followingForums.indexOf(forum.forumid);
      if (index2 > -1) {
        this.user.followingForums.splice(index2, 1);
      }
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
      console.log(data);
    })
    this.userservice.getForum(this.forumid).subscribe((data: Forums) => {
      this.forum = data;
      this.ui = this.forum.ui;
      this.setui();
      this.followVisibility = true;
      data.followers.forEach(follower => {
        if (follower===this.user.userId) {
          this.followVisibility = false;
        }
      });
      return;
    })
  }

  upvotePost(post: Posts) {
    post.upvote += 1;
    this.posts = this.posts.sort((a, b) => b.upvote - a.upvote);
    this.feedservice.updatePost(post).subscribe((data: any) => {
      console.log(data);
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

  setCommentContent(event: any) {
    this.newcommentcontent = event.target.value;
  }

  postComment(post: Posts) {
    if (this.newcommentcontent) {
      if(confirm("Are you sure to comment? It can't be deleted later!")) {
      this.newcomment.commentcontent = this.newcommentcontent;
      this.newcomment.postid = post.postid;
      this.newcomment.commenterid = this.user.userId;
      this.newcomment.postownerid = post.ownerid;
      this.lastidservice.getlastid().subscribe((data: Lastid) => {
        this.newcomment.commentid = data.commentid + 1;
        data.commentid = this.newcomment.commentid;
        this.lastidservice.updatelastid(data).subscribe((data2: any) => {
          console.log(data2);
          this.feedservice.postCommment(this.newcomment).subscribe((data3: any) => {
            console.log(data3);
            post.comments.push(this.newcomment.commentid);
            this.feedservice.updatePost(post).subscribe((data4: any) => {
              console.log(data4);
            });
            this.getForum(post.forumid);
          })
        })
      })
    }
    } else {
      alert("No content to be commented");
    }
  }
}
