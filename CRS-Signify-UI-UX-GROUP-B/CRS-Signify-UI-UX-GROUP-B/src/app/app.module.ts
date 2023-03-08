import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { UsercomponentComponent } from './Component/usercomponent/usercomponent.component';

import { AdmincomponentComponent } from './Component/admincomponent/admincomponent.component';
import { LogincomponentComponent } from './Component/logincomponent/logincomponent.component';
import { AddprofessorComponent } from './Component/addprofessor/addprofessor.component';

import { ViewunapproveComponent } from './Component/viewunapprove/viewunapprove.component';
import { ApprovestudentComponent } from './Component/approvestudent/approvestudent.component';
import { AddcourseComponent } from './Component/addcourse/addcourse.component';
import { RemovecourseComponent } from './Component/removecourse/removecourse.component';
import { ViewcourseComponent } from './Component/viewcourse/viewcourse.component';
import { AddadminComponent } from './Component/addadmin/addadmin.component';
import { GeneratereportComponent } from './Component/generatereport/generatereport.component';

@NgModule({
  declarations: [
    AppComponent,
    //UsercomponentComponent,
    LogincomponentComponent,
    AdmincomponentComponent,
    AddprofessorComponent,
    ViewunapproveComponent,
    ApprovestudentComponent,
    AddcourseComponent,
    RemovecourseComponent,
    ViewcourseComponent,
    AddadminComponent,
    GeneratereportComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
