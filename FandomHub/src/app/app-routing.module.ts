import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfileComponent } from './components/profile/profile.component';
import { AppComponent } from './app.component';
import { FeedPageComponent } from './components/feed-page/feed-page.component';
import { LoginComponent } from './components/login/login.component';
import { AuthgaurdService } from './services/authgaurd.service';
import { MyforumComponent } from './components/myforum/myforum.component';
import { NewforumComponent } from './components/newforum/newforum.component';
import { NewpostComponent } from './components/newpost/newpost.component';
import { EditProfileComponent } from './components/editprofile/editprofile.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthgaurdService] },
  { path: 'feed', component: FeedPageComponent, canActivate: [AuthgaurdService] },
  { path: 'login', component: LoginComponent },
  { path: 'myforum/:id', component: MyforumComponent, canActivate: [AuthgaurdService] },
  { path: 'newforum', component: NewforumComponent, canActivate: [AuthgaurdService] },
  { path: 'newpost/:id', component: NewpostComponent, canActivate: [AuthgaurdService] },
  { path: 'editprofile', component: EditProfileComponent, canActivate: [AuthgaurdService] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
