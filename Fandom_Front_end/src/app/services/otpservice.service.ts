import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Otpbody } from '../classes/otpbody';

@Injectable({
  providedIn: 'root'
})
export class OtpserviceService {

  constructor(private http: HttpClient) { }

  private baseurl = "http://localhost:8090/otp/";

  getOtp(body: Otpbody) {
    return this.http.post(`${this.baseurl}send-otp`, body, {responseType: 'text' as 'json'});
    // return this.http.get("");
  }
}
