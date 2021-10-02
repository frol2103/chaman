import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Item, ItemService} from "../../../generated/api";
import {ItemImpl} from "../../model/ItemImpl";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-item-card',
  templateUrl: './item-card.component.html',
  styleUrls: ['./item-card.component.css']
})
export class ItemCardComponent implements OnInit {

  item: Item

  constructor(
    public route: ActivatedRoute,
    private itemService: ItemService,
  ) {
    route.params.subscribe(p => {
        if (p.id === 'new') {
          this.item = new ItemImpl()
        }
        else itemService.getItem(p.id).toPromise().then(i => this.item = i)
      }
    )
  }


  ngOnInit(): void {

  }


  save(){
    if(this.item.uuid){
      this.itemService.updateItem(this.item.uuid, this.item).toPromise().then(i => this.item = i)
    } else {
      this.itemService.createItem(this.item).toPromise().then(i => this.item = i)
    }
  }
}
