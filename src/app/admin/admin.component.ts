import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminserviceService } from '../adminservice.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin:Admin = new Admin();
  submitted:boolean = false;

  constructor(private adminService:AdminserviceService,private route:Router) { }

  ngOnInit(): void {
  }

  login(){
    this.adminService.adminLogin(this.admin)
    .subscribe(
      admin => {
        if(admin != null){
          this.submitted = true;
          this.route.navigate(['adminLogin']);
        }
        else{
          this.submitted = false;
        }
      }
    );
  }
  onSubmit(){
    this.login();
  }
}

