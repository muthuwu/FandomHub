import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lastid } from '../classes/lastid';

@Injectable({
  providedIn: 'root'
})
export class LastidService {

  constructor(private http: HttpClient) { }

  private baseurl = "http://localhost:8080/lastidapi/";

  getlastid(): Observable<Lastid> {
    return this.http.get<Lastid>(`${this.baseurl}`+"getlastid");
  }

  postlastid(lastid: Lastid) {
    return this.http.put(`${this.baseurl}updatelastid`, lastid, {responseType: 'text' as 'json'});
  }

}
