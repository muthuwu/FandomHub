import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Forums } from '../classes/forums';
import { UserProfile } from '../classes/user-profile';
import { Lastid } from '../classes/lastid';
import { Posts } from '../classes/posts';

@Injectable({
  providedIn: 'root'
})
export class ProfileserviceService {

  constructor(private http: HttpClient) { }

  private baseurl = "http://localhost:8080/";


  getMyforums(userid: number): Observable<Forums[]> {
    return this.http.get<Forums[]>(`${this.baseurl}`+"getmyforums/"+userid);
  }

  getUser(userid: number): Observable<UserProfile> {
    return this.http.get<UserProfile>(`${this.baseurl}`+"getmyuser/"+userid);
  }

  getUserAuth(phonenumber: number): Observable<UserProfile> {
    return this.http.get<UserProfile>(`${this.baseurl}loginauth/`+phonenumber);
  }

  getForum(forumid: number): Observable<Forums> {
    return this.http.get<Forums>(`${this.baseurl}getforum/`+forumid);
  }

  newUser(user: UserProfile) {
    return this.http.post(`${this.baseurl}adduser`, user, {responseType: 'text' as 'json'});
  }

  addForum(forum: Forums) {
    return this.http.post(`${this.baseurl}addforum`, forum, {responseType: 'text' as 'json'});
  }

  updateUser(user: UserProfile) {
    return this.http.put(`${this.baseurl}updateuser`, user, {responseType: 'text' as 'json'});
  }

  addPost(post: Posts) {
    return this.http.post(`${this.baseurl}addpost`, post, {responseType: 'text' as 'json'});
  }

  updateForum(forum: Forums) {
    return this.http.put(`${this.baseurl}updateforum`, forum, {responseType: 'text' as 'json'});
  }

  deleteUser(id: number) {
    return this.http.delete(`${this.baseurl}deleteuser/`+id,{responseType: 'text' as 'json'});
  }
}
