import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  private getUsersUrl:string = "http://localhost:8080/login";
  constructor(private httpClient:HttpClient) { }

  login(model: Login): Observable<any>{
    //console.log("model id"+model.id);
    return this.httpClient.post(`${this.getUsersUrl}`, model);
  }
}
