import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ItemDescr, ItemService} from "../../../generated/api";
import {RxjsHelperService} from "../../rxjs-helper.service";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(
    private routerService: Router,
    private itemService: ItemService,
    private r : RxjsHelperService,
  ) { }

  ngOnInit(): void {
  }

  newItem() {
    this.routerService.navigate(["/item/new"])
    this.r.wrap(this.itemService.createItem())
      .withErrorMessage("Error while creating a new item")
      .then(i => this.goTo(i))
  }

  goTo(item: ItemDescr) {
    this.redirect(item);
  }

  private redirect(item: ItemDescr) {
    this.routerService.navigate(["/item/", item.uuid])
  }
}
