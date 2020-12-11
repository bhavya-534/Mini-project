import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestsService {

  private baseUrl='http://localhost:8081/api';


  constructor(private http: HttpClient) { }
 
 
   Requests(requests:any):Observable<any>{
     return this.http.post(`${this.baseUrl}` + `/requestors`,requests);
 
   }
}

