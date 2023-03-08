import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from 'src/app/Service/adminservice.service';

@Component({
  selector: 'app-viewunapprove',
  templateUrl: './viewunapprove.component.html',
  styleUrls: ['./viewunapprove.component.css']
})
export class ViewunapproveComponent implements OnInit {
  results:any;
  constructor(private viewUnapproveObject:AdminserviceService) { }
  
  ngOnInit(): void {
  }

  public view_unapprove(){
    console.log("Viewing unapproved students here");
    this.viewUnapproveObject.viewUnapprove().subscribe(data => {
      this.results = data;
      console.log(data);

    });
  }
}
