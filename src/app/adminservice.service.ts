import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {
  private baseUrl = 'http://localhost:8081/api/admin';

  constructor(private http:HttpClient) { }

  adminLogin(admin:any):Observable<any>{
    return this.http.post(this.baseUrl,admin);
  }
}
