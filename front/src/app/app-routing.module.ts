import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FieldsComponent} from "./admin/fields/fields/fields.component";
import {HomeComponent} from "./home/home.component";


const routes: Routes = [
  {path: 'admin/fields', component: FieldsComponent},
  {path:'', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
