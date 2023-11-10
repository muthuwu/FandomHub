import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Forums } from '../classes/forums';
import { Posts } from '../classes/posts';

@Injectable({
  providedIn: 'root'
})
export class FeedserviceService {
  constructor(private http: HttpClient) { }

  private baseurl = "http://localhost:8080/feedapi/";

  getFollowingForums(userid: number): Observable<Forums[]> {
    return this.http.get<Forums[]>(`${this.baseurl}`+"getfollowingforums/"+userid);
  }

  getForumPosts(forumid: number): Observable<Posts[]> {
    return this.http.get<Posts[]>(`${this.baseurl}getforumposts/`+forumid);
  }

  followNewForum(forum: Forums) {
    return this.http.put(`${this.baseurl}follownewforum`, forum, {responseType: 'text' as 'json'});
  }

  getAllForums(): Observable<Forums[]> {
    return this.http.get<Forums[]>(`${this.baseurl}getallforums`);
  }
}
