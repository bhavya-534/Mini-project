import { Component, OnInit } from '@angular/core';
import { RequestDeclaration } from '../RequestDeclaration';
import { UserService } from '../user.service';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {

  requests:RequestDeclaration=new RequestDeclaration();
  
  submitted = false;

  constructor(private userService : UserService) { }
  ngOnInit(): void {
    
  }

  
  newRequest(): void{
    this.submitted = false;
    this.requests= new RequestDeclaration();
  }

  save(){
    this.userService.Request(this.requests)
    
    .subscribe(
      data => {
        console.log(data);
        this.submitted=true;
      },
      error=>console.log(error));
      this.requests= new RequestDeclaration();
  }

  onSubmit(){
    this.save();
  }

}

