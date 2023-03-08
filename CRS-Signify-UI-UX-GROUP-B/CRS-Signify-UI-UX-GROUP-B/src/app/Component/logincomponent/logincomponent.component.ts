import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Login } from 'src/app/model/login';
import { LoginServiceService } from 'src/app/Service/loginservice.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-logincomponent',
  templateUrl: './logincomponent.component.html',
  styleUrls: ['./logincomponent.component.css']
})
export class LogincomponentComponent implements OnInit {
  adminArray:Array<Login> = new Array();
  model = new Login(0,'','');

  constructor(private router:Router,private loginObject:LoginServiceService) { }

  ngOnInit(): void {
  }
  public login_call(){
    this.loginObject.login(this.model).subscribe(
      () => this.router.navigate(['/admin'])
      ,
      (error : HttpErrorResponse) => {
        if(error.status !== 200){
          alert("Invalid credentials!!");
        }
      }
    );
  }

}
