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

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    MenuItemComponent,
    MenuGroupComponent,
    FieldTableComponent,
    FieldsComponent,
    HomeComponent
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
