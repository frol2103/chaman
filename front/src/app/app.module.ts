import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu/menu.component';
import { MenuItemComponent } from './menu/menu-item/menu-item.component';
import { MenuGroupComponent } from './menu/menu-group/menu-group.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { FieldTableComponent } from './admin/fields/field-table/field-table.component';
import { FieldsComponent } from './admin/fields/fields/fields.component';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {BASE_PATH} from "../generated/api";
import { FieldEditComponent } from './admin/fields/field-edit/field-edit.component';
import { ToastComponent } from './toast/toast.component';
import { FieldComponent } from './field/core/field/field.component';
import {FieldDirective} from "./field/core/field.directive";
import { StringComponent } from './field/template/string/string.component';
import { IntegerComponent } from './field/template/integer/integer.component';
import { TemplatesComponent } from './admin/templates/templates/templates.component';
import { TemplateTableComponent } from './admin/templates/template-table/template-table.component';
import { TemplateEditComponent } from './admin/templates/template-edit/template-edit.component';
import { WaitComponent } from './wait/wait.component';
import { WaitDirective } from './wait/wait.directive';
import { FieldSelectorComponent } from './admin/templates/field-selector/field-selector.component';
import { TemplateSelectorComponent } from './admin/templates/template-selector/template-selector.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    MenuItemComponent,
    MenuGroupComponent,
    FieldTableComponent,
    FieldsComponent,
    HomeComponent,
    FieldEditComponent,
    ToastComponent,
    FieldComponent,
    FieldDirective,
    StringComponent,
    IntegerComponent,
    TemplatesComponent,
    TemplateTableComponent,
    TemplateEditComponent,
    WaitComponent,
    WaitDirective,
    FieldSelectorComponent,
    TemplateSelectorComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
  ],
  providers: [
    {provide: BASE_PATH, useValue: '/api'},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
