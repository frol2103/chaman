import { Component, OnInit } from '@angular/core';
import {Item, ItemService} from "../../../generated/api";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-item-search',
  templateUrl: './item-search.component.html',
  styleUrls: ['./item-search.component.css']
})
export class ItemSearchComponent implements OnInit {

  items: Array<Item>;

  constructor(
    private itemService : ItemService,
    private routerService: Router,
  ) {
    this.itemService.getItems().toPromise().then(i => {
      this.items =i
      console.log("items", this.items)
    })
  }

  ngOnInit(): void {
  }

  newItem() {
    this.routerService.navigate(["/item/new"])
  }
}
