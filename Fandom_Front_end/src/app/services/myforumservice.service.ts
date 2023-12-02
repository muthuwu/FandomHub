import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MyforumserviceService {
  constructor(private http: HttpClient) { }

  private base2url = "http://localhost:8080/myforumapi/";

  deleteForum(forumid: number) {
    return this.http.delete(`${this.base2url}deleteforum/`+ forumid, {responseType: 'text' as 'json'});
  }

  deletePost(postid: number) {
    return this.http.delete(`${this.base2url}deletepost/`+ postid, {responseType: 'text' as 'json'});
  }
}
