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
import { WaitComponent } from './wait/wait.component';
import { WaitDirective } from './wait/wait.directive';
import { FieldSelectorComponent } from './admin/fields/field-selector/field-selector.component';
import { FieldValueComponent } from './field/core/field-value/field-value.component';
import { ItemSearchComponent } from './item/item-search/item-search.component';
import { ItemCardComponent } from './item/item-card/item-card.component';

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
    WaitComponent,
    WaitDirective,
    FieldSelectorComponent,
    FieldValueComponent,
    ItemSearchComponent,
    ItemCardComponent,
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
