import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FieldsComponent} from "./fields/fields/fields.component";
import {ItemCardComponent} from "./item/item-card/item-card.component";
import {ItemSearchComponent} from "./item/item-search/item-search.component";
import {ItemsComponent} from "./item/items/items.component";


const routes: Routes = [
  {path: 'admin/fields', component: FieldsComponent},
  {path: 'item/:id', component: ItemCardComponent},
  {path: 'item', component: ItemsComponent},
  {path:'', component: ItemsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
