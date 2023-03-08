import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddadminComponent } from './Component/addadmin/addadmin.component';
import { AddcourseComponent } from './Component/addcourse/addcourse.component';
import { AddprofessorComponent } from './Component/addprofessor/addprofessor.component';
import { AdmincomponentComponent } from './Component/admincomponent/admincomponent.component';
import { ApprovestudentComponent } from './Component/approvestudent/approvestudent.component';
import { GeneratereportComponent } from './Component/generatereport/generatereport.component';
import { LogincomponentComponent } from './Component/logincomponent/logincomponent.component';
import { RemovecourseComponent } from './Component/removecourse/removecourse.component';
import { ViewcourseComponent } from './Component/viewcourse/viewcourse.component';
import { ViewunapproveComponent } from './Component/viewunapprove/viewunapprove.component';

const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'home',component:LogincomponentComponent},
  {path:'admin',component:AdmincomponentComponent},
  {path:'addProfessor',component:AddprofessorComponent},
  {path:'removeCourse',component:RemovecourseComponent},
  {path:'viewCourse',component:ViewcourseComponent},
  {path:'approveStudent',component:ApprovestudentComponent},
  {path:'addCourse',component:AddcourseComponent},
  {path:'generateReport',component:GeneratereportComponent},
  {path:'viewUnapprove',component:ViewunapproveComponent},
  {path:'addAdmin',component:AddadminComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
