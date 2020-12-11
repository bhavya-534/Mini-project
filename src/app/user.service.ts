import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseUrl='http://localhost:8081/api';


 constructor(private http: HttpClient) { }

 Register(user:any):Observable<any>{
  return this.http.post(`${this.baseUrl}` + `/users`,user);
 }

 Donar(donars:any):Observable<any>{
  return this.http.post(`${this.baseUrl}` + `/donators`,donars);

}

Request(requests:any):Observable<any>{
  return this.http.post(`${this.baseUrl}` + `/requestors`,requests);

}

updateAccept(requests:any):Observable<any>{
  return this.http.put(`${this.baseUrl}` + `/requestors1`,requests);

}

updateReject(requests:any):Observable<any>{
  return this.http.put(`${this.baseUrl}` + `/requestors1`,requests);

}

updateDonarAccept(donars:any):Observable<any>{
  return this.http.put(`${this.baseUrl}` + `/donators1`,donars);

}

updateDonarReject(donars:any):Observable<any>{
  return this.http.put(`${this.baseUrl}` + `/donators1`,donars);

}

getStatus():Observable<any>{
  
  return this.http.get(`${this.baseUrl}` + `/status`);
}

getState():Observable<any>{
  
  return this.http.get(`${this.baseUrl}` + `/state`);
}


getStatusRequestor(patientName: string): Observable<any> {
  return this.http.get(`${this.baseUrl}/requestors/patientName/${patientName}`);
}

getStatusDonator(id: number): Observable<any> {
  return this.http.get(`${this.baseUrl}/donators/id/${id}`);
}


getStatusBlood(bloodGroup: string): Observable<any> {
  return this.http.get(`${this.baseUrl}/donators/bloodGroup/${bloodGroup}`);
}
}
