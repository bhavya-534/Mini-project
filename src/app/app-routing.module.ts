import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { DetailsComponent } from './details/details.component';
import { DonarComponent } from './donar/donar.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { RequestComponent } from './request/request.component';
import { StatusComponent } from './status/status.component';

const routes: Routes = [
  {path:'home',component : HomeComponent},
  {path:'register',component : RegisterComponent},
  {path:'admin',component : AdminComponent},
  {path:'status',component : StatusComponent},
  {path:'donar',component : DonarComponent},
  {path:'detail',component : DetailsComponent},
  {path:'request',component : RequestComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
