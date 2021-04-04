import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FieldsComponent} from "./admin/fields/fields/fields.component";
import {HomeComponent} from "./home/home.component";
import {TemplatesComponent} from "./admin/templates/templates/templates.component";
import {TemplateEditComponent} from "./admin/templates/template-edit/template-edit.component";


const routes: Routes = [
  {path: 'admin/fields', component: FieldsComponent},
  {path: 'admin/templates', component: TemplatesComponent},
  {path: 'admin/template/:id', component: TemplateEditComponent},
  {path:'', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
