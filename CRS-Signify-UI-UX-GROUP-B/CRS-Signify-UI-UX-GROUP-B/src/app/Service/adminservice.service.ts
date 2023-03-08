import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../model/admin';

@Injectable({
  providedIn: 'root'
})

export class AdminserviceService {
  private getUsersUrl:string = "http://localhost:8080";
  constructor(private httpClient:HttpClient) { }

  addProfessor(model1:Admin): Observable<any>{
    //console.log("model id"+model.id);
    let url:string = "/addProf";
    let final_url = this.getUsersUrl + url;
    return this.httpClient.post(`${final_url}`, model1);
  }

  viewUnapprove(): Observable<any>{
    //console.log("model id"+model.id);
    let url:string = "/viewUnapproved";
    let final_url = this.getUsersUrl + url;
    return this.httpClient.get(`${final_url}`);

    
  }

  approveStudent(modell:Admin): Observable<any>{
    //console.log("model id"+model.id);
    let url:string = "/approveStudent";
    let final_url = this.getUsersUrl + url
    return this.httpClient.post(`${final_url}`, modell);
  }

  addCourse(modell:Admin): Observable<any>{
    //console.log("model id"+model.id);
    let url:string = "/addCourse";
    let final_url = this.getUsersUrl + url;
    return this.httpClient.post(`${final_url}`, modell);
  }

  removeCourse(modell:Admin): Observable<any>{
    //console.log("model id"+model.id);
    let url:string = "/removeCourse";
    let final_url = this.getUsersUrl + url;
    return this.httpClient.post(`${final_url}`, modell);
  }

  viewCourse(): Observable<any>{
    //console.log("model id"+model.id);
    let url:string = "/viewCourses";
    let final_url = this.getUsersUrl + url;
    return this.httpClient.get(`${final_url}`);
  }

  addAdmin(modell:Admin): Observable<any>{
    //console.log("model id"+model.id);
    let url:string = "/addAdmin";
    let final_url = this.getUsersUrl + url;
    return this.httpClient.post(`${final_url}`, modell);
  }

  generateReport(modell:Admin): Observable<any>{
    //console.log("model id"+model.id);
    let url:string = "/viewGradeCard";
    let final_url = this.getUsersUrl + url;
    return this.httpClient.post(`${final_url}`, modell);
  }
}
