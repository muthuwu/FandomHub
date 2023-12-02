import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Forums } from '../classes/forums';
import { Posts } from '../classes/posts';
import { Comments } from '../classes/comments';

@Injectable({
  providedIn: 'root'
})
export class FeedserviceService {
  constructor(private http: HttpClient) { }

  private baseurl = "http://localhost:8080/feedapi/";

  private base2url = "http://localhost:8080/commentsapi/";

  getFollowingForums(userid: number): Observable<Forums[]> {
    return this.http.get<Forums[]>(`${this.baseurl}`+"getfollowingforums/"+userid);
  }

  getForumPosts(forumid: number): Observable<Posts[]> {
    return this.http.get<Posts[]>(`${this.baseurl}getforumposts/`+forumid);
  }

  followUnfollowForum(forum: Forums) {
    return this.http.put(`${this.baseurl}followunfollowforum`, forum, {responseType: 'text' as 'json'});
  }

  getAllForums(): Observable<Forums[]> {
    return this.http.get<Forums[]>(`${this.baseurl}getallforums`);
  }

  updatePost(post: Posts) {
    return this.http.put(`${this.baseurl}updatepost`,post, {responseType: 'text' as 'json'});
  }

  getPostComments(id: number): Observable<Comments[]> {
    return this.http.get<Comments[]>(`${this.base2url}getpostcomments/`+id);
  }

  postCommment(comment: Comments) {
    return this.http.post(`${this.base2url}postcomment`, comment, {responseType: 'text' as 'json'});
  }
}

