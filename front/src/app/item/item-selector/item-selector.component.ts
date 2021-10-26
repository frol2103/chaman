import { Component, OnInit } from '@angular/core';
import {ItemDescr} from "../../../generated/api";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-item-selector',
  templateUrl: './item-selector.component.html',
  styleUrls: ['./item-selector.component.css']
})
export class ItemSelectorComponent implements OnInit {

  constructor(
    public modal: NgbActiveModal,
  ) { }

  ngOnInit(): void {
  }

  select(itemDesc:ItemDescr) : void {
    this.modal.close(itemDesc)
  }
}
