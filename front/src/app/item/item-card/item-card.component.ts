import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Field, Item, ItemService} from "../../../generated/api";
import {ItemImpl} from "../../model/ItemImpl";
import {map} from "rxjs/operators";
import {RxjsHelperService} from "../../rxjs-helper.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FieldSelectorComponent} from "../../admin/fields/field-selector/field-selector.component";

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
    private r: RxjsHelperService,
    private modalService: NgbModal,
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

  openSticker(content){
    this.modalService.open(content)
  }

  save(){
    this.r.wrap((this.item.uuid) ?
      this.itemService.updateItem(this.item.uuid, this.item) :
      this.itemService.createItem(this.item))
      .withErrorMessage("Error while saving item")
      .withSuccessMessage("Item saved")
      .then(v => this.item = v)
  }



  startAddField(){
    if(!this.item.content) this.item.content = []
    this.modalService.open(FieldSelectorComponent).result.then((result) => {
      this.item.content.push(result)
    });
  }

  deleteField(field: Field){
    this.item.content.splice(this.item.content.indexOf(field),1)
  }

}
