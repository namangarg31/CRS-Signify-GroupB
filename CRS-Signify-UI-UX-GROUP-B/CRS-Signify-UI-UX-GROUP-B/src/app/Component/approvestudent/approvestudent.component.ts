import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { AdminserviceService } from 'src/app/Service/adminservice.service';

@Component({
  selector: 'app-approvestudent',
  templateUrl: './approvestudent.component.html',
  styleUrls: ['./approvestudent.component.css']
})
export class ApprovestudentComponent implements OnInit {
  professorArray:Array<Admin> = new Array();
  model = new Admin(0,'','','','','','',0,'',0,'');

  constructor(private approveStudentObject:AdminserviceService ) { }

  ngOnInit(): void {
  }

  public approve_student(){
    //console.log("approve student");
    this.approveStudentObject.approveStudent(this.model).subscribe(
      
      (data) => alert(data.entity),
      (error : HttpErrorResponse) => {
        if(error.status !== 200){
          alert("Student not found!!");
        }
      }
    );
  }

}
