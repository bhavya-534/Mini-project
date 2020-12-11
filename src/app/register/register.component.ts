import { Component, OnInit } from '@angular/core';
import { UserDeclaration } from 'src/app/UserDeclaration';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  
  user: UserDeclaration = new UserDeclaration();
  submitted = false;

  constructor(private userService : UserService) { }
  ngOnInit(): void {
    
  }

  
  newUser(): void{
    this.submitted = false;
    this.user = new UserDeclaration();
  }

  save(){
    this.userService.Register(this.user)
    
    .subscribe(
      data => {
        console.log(data);
        this.submitted=true;
      },
      error=>console.log(error));
      this.user=new UserDeclaration();
  }

  onSubmit(){
    this.save();
  }

}
