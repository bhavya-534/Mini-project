import { Component, OnInit } from '@angular/core';
import { DonarDeclaration } from '../DonarDeclaration';
import { UserService } from '../user.service';



@Component({
  selector: 'app-donar',
  templateUrl: './donar.component.html',
  styleUrls: ['./donar.component.css']
})
export class DonarComponent implements OnInit {

  donars:DonarDeclaration=new DonarDeclaration();

  
  submitted = false;

  constructor(private userService : UserService) { }
  ngOnInit(): void {
    
  }

  
  newDonar(): void{
    this.submitted = false;
    this.donars = new DonarDeclaration();
  }

  save(){
    this.userService.Donar(this.donars)
    
    .subscribe(
      data => {
        console.log(data);
        this.submitted=true;
      },
      error=>console.log(error));
      this.donars = new DonarDeclaration();
  }

  onSubmit(){
    this.save();
  }

}
