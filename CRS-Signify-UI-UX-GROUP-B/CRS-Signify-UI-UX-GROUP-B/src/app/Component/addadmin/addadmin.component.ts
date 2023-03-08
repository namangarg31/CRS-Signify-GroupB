import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { AdminserviceService } from 'src/app/Service/adminservice.service';

@Component({
  selector: 'app-addadmin',
  templateUrl: './addadmin.component.html',
  styleUrls: ['./addadmin.component.css']
})
export class AddadminComponent implements OnInit {
  adminArray:Array<Admin> = new Array();
  model = new Admin(0,'','','','','','',0,'',0,'');

  constructor(private addAdminObject:AdminserviceService) { }

  

  ngOnInit(): void {
  }
  public add_admin(){
    this.addAdminObject.addAdmin(this.model).subscribe(
      (data) => alert("Admin Added, with id "+data),
      (error : HttpErrorResponse) => {
        if(error.status !== 200){
          alert("Error creating admin!!");
        }
      }
    );

  }

}
