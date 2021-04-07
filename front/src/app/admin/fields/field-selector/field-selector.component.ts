import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Field, FieldService} from "../../../../generated/api";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-field-selector',
  templateUrl: './field-selector.component.html',
  styleUrls: ['./field-selector.component.css']
})
export class FieldSelectorComponent implements OnInit {

  constructor(
    private fieldService : FieldService,
    public modal: NgbActiveModal,
  ) { }


  fields = this.fieldService.getField().toPromise()

  ngOnInit(): void {
  }


}
