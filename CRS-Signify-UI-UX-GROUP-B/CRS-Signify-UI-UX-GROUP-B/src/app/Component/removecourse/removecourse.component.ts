import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { AdminserviceService } from 'src/app/Service/adminservice.service';

@Component({
  selector: 'app-removecourse',
  templateUrl: './removecourse.component.html',
  styleUrls: ['./removecourse.component.css']
})
export class RemovecourseComponent implements OnInit {
  adminArray:Array<Admin> = new Array();
  model = new Admin(0,'','','','','','',0,'',0,'');

  constructor(private removeCourseObject:AdminserviceService) { }

  ngOnInit(): void {
  }
  public remove_course(){
    //console.log("Removing course here");
    this.removeCourseObject.removeCourse(this.model).subscribe(
      (data) => alert(data.entity)
      ,
      (error : HttpErrorResponse) => {
        if(error.status !== 200){
          alert("Course Name not found!!");
        }
      }
    );
  }

}
