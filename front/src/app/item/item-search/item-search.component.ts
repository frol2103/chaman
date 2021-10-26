import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Item, ItemDescr, ItemService} from "../../../generated/api";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-item-search',
  templateUrl: './item-search.component.html',
  styleUrls: ['./item-search.component.css']
})
export class ItemSearchComponent implements OnInit {

  @Output() selection = new EventEmitter<ItemDescr>()

  items: Array<ItemDescr>;

  constructor(
    private itemService : ItemService,
  ) {
    this.itemService.getItems().toPromise().then(i => {
      this.items =i
    })
  }

  ngOnInit(): void {
  }

}
