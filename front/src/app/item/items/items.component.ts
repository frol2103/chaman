import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ItemDescr} from "../../../generated/api";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  constructor(
    private routerService: Router,
  ) { }

  ngOnInit(): void {
  }

  newItem() {
    this.routerService.navigate(["/item/new"])
  }

  goTo(item: ItemDescr) {
    this.routerService.navigate(["/item/", item.uuid])
  }
}
