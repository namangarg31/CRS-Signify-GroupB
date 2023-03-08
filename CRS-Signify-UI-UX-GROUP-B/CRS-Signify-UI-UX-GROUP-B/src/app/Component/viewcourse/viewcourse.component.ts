import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from 'src/app/Service/adminservice.service';

@Component({
  selector: 'app-viewcourse',
  templateUrl: './viewcourse.component.html',
  styleUrls: ['./viewcourse.component.css']
})
export class ViewcourseComponent implements OnInit {
  //responsed:Array<any> =new Array();
  results: any;
  constructor(private viewCourseObject:AdminserviceService) { }

  ngOnInit(): void {
  }

  public view_course(){
    console.log("Viewing course here");
    this.viewCourseObject.viewCourse().subscribe(data => {
      console.log(data);
      // for(let item in data){
      //   this.responsed.push(item);
      // }
      this.results = data;
    });
  }
}
