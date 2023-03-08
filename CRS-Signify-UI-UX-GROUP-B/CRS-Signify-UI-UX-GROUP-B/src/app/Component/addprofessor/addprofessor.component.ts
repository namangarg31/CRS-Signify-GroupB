import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { AdminserviceService } from 'src/app/Service/adminservice.service';

@Component({
  selector: 'app-addprofessor',
  templateUrl: './addprofessor.component.html',
  styleUrls: ['./addprofessor.component.css']
})
export class AddprofessorComponent implements OnInit {
  professorArray:Array<Admin> = new Array();
  model = new Admin(0,'','','','','','',0,'',0,'');

  constructor(private profObject:AdminserviceService ) { }

  ngOnInit(): void {
  }

  public add_professor(){
    this.profObject.addProfessor(this.model).subscribe(
      (data) => alert("Professor Added, with id "+data),
      (error : HttpErrorResponse) => {
        if(error.status !== 200){
          alert("Unauthorized!!");
        }
      }
    );
  }



}
