import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DonarComponent } from '../donar/donar.component';
import { DonarDeclaration } from '../DonarDeclaration';
import { RegisterComponent } from '../register/register.component';
import { RequestDeclaration } from '../RequestDeclaration';
import { UserService } from '../user.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  requestors : Observable<RegisterComponent[]>;

  donators : Observable<DonarComponent[]>;



  constructor(private userService : UserService) { }

  ngOnInit(): void {
    this.reloadData();
    this.reload();
    
  }

  accept(request:RequestDeclaration)
  {
    request.status="Accepted";
    this.userService.updateAccept(request).subscribe();
  }

  reject(request:RequestDeclaration)
  {
    request.status="Rejected";
    this.userService.updateReject(request).subscribe();
  }

  reloadData()
  {
    this.requestors=this.userService.getStatus();
  }


  
  Reject(donar:DonarDeclaration)
  {
    donar.status="Rejected";
    this.userService.updateDonarReject(donar).subscribe();
  }

  Accept(donar:DonarDeclaration)
  {
    donar.status="Accepted";
    this.userService.updateDonarAccept(donar).subscribe();
  }

  
 
  reload()
  {
    this.donators=this.userService.getState();
  }
  

}
