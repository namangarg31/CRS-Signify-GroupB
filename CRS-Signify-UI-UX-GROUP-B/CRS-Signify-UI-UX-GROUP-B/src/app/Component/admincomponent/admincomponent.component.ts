import { Component, Inject, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { AdminserviceService } from 'src/app/Service/adminservice.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admincomponent',
  templateUrl: './admincomponent.component.html',
  styleUrls: ['./admincomponent.component.css']
})
export class AdmincomponentComponent implements OnInit {
  adminArray:Array<Admin> = new Array();
  modell = new Admin(0,'','','','','','',0,'',0,'');
 

  constructor(private router:Router,@Inject(AdminserviceService) private adminObject: AdminserviceService) {}

  ngOnInit(): void {
  }

  public addprofessor_call(){
    console.log("called");
    this.router.navigate(['/addProfessor'])
  }

  public viewUnapprove_call(){
    this.router.navigate(['/viewUnapprove'])
  }

  public approveStudent_call(){
    this.router.navigate(['/approveStudent'])
  }

  public addcourse_call(){
    this.router.navigate(['/addCourse'])
  }

  public removecourse_call(){
    this.router.navigate(['/removeCourse'])
  }

  public viewcourse_call(){
    this.router.navigate(['/viewCourse'])
   
  }

  public addadmin_call(){
    this.router.navigate(['/addAdmin'])
  }

  public generatereport_call(){
    this.router.navigate(['/generateReport'])
  }

}