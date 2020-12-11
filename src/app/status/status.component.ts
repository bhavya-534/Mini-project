import { Component, Input, OnInit } from '@angular/core';
import { DonarDeclaration } from '../DonarDeclaration';
import { RequestDeclaration } from '../RequestDeclaration';
import { UserService } from '../user.service';


@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  
  patientName:string;

  id:number;

  bloodGroup:string;

  requestors:RequestDeclaration[];
  donators:DonarDeclaration[];

  constructor(private userService:UserService) { }

  ngOnInit() {
    this.patientName=null;
    this.id=null;
    this.bloodGroup=null;
  }

  private searchStatusRequestor() {
    this.requestors = [];
    this.userService.getStatusRequestor(this.patientName)
      .subscribe(requestors => this.requestors = requestors);
  }
 
  private searchStatusDonator() {
    this.donators = [];
    this.userService.getStatusDonator(this.id)
      .subscribe(donators=> this.donators = donators);
  }

  private searchbloodGroup() {
    this.donators = [];
    this.userService.getStatusBlood(this.bloodGroup)
      .subscribe(donators=> this.donators = donators);
  }

  onSubmit() {
    this.searchStatusRequestor();
    this.searchStatusDonator();
    this.searchbloodGroup();
  }

  
}



