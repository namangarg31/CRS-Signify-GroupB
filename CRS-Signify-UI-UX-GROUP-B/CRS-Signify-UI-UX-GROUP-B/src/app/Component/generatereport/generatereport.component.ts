import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/model/admin';
import { AdminserviceService } from 'src/app/Service/adminservice.service';

@Component({
  selector: 'app-generatereport',
  templateUrl: './generatereport.component.html',
  styleUrls: ['./generatereport.component.css']
})
export class GeneratereportComponent implements OnInit {
  professorArray:Array<Admin> = new Array();
  model = new Admin(0,'','','','','','',0,'',0,'');
  results: any;

  constructor(private generateReportObject:AdminserviceService ) { }

  ngOnInit(): void {
  }

  public generate_report(){
    console.log("approve student");
    this.generateReportObject.generateReport(this.model).subscribe(data => {
      console.log(data);
      this.results = data;
    })
  }

}
