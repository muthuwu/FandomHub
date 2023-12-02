import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ProfileserviceService } from './services/profileservice.service';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FeedPageComponent } from './components/feed-page/feed-page.component';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MyforumComponent } from './components/myforum/myforum.component';
import { NewforumComponent } from './components/newforum/newforum.component';
import { NewpostComponent } from './components/newpost/newpost.component';
import { EditProfileComponent } from './components/editprofile/editprofile.component';
import { OtpComponent } from './components/otp/otp.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    EditProfileComponent,
    FeedPageComponent,
    MyforumComponent,
    NewforumComponent,
    NewpostComponent,
    OtpComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
  ],
  providers: [ProfileserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
