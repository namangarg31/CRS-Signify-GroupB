import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { AdminserviceService } from 'src/app/Service/adminservice.service';

@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css']
})
export class AddcourseComponent implements OnInit {
  courseArray:Array<Admin> = new Array();
  model = new Admin(0,'','','','','','',0,'',0,'');
  constructor(private addCourseObject:AdminserviceService) { }

  

  ngOnInit(): void {
  }
  public addCourse(){
    this.addCourseObject.addCourse(this.model).subscribe(
      
      (data) => alert(data.entity),
      (error : HttpErrorResponse) => {
        if(error.status !== 200){
          alert("Unauthorized!!");
        }
      }
    );

  }

}
