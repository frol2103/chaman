import {Component, OnInit} from '@angular/core';
import {Field, FieldService} from "../../../generated/api";
import {FieldImpl} from "../../model/FieldImpl";
import * as _ from 'lodash';
import {NgbModal, NgbModalConfig, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'fields',
  templateUrl: './fields.component.html',
  styleUrls: ['./fields.component.css']
})
export class FieldsComponent implements OnInit {

  constructor(
    private fieldService: FieldService,
    private modalService: NgbModal,
    private config: NgbModalConfig,
  ) {
    this.config.size = 'xl'
  }

  modalRef: NgbModalRef
  fields: Array<Field>
  editionFieldUuid: string
  inEdit = false

  ngOnInit(): void {
    this.fieldService.getField().toPromise().then(l => this.fields = l)
  }

  newField(tpl) {
    this.editionFieldUuid = undefined;
    this.inEdit = true;
    this.modalRef = this.modalService.open(tpl)
  }

  fieldUpdated(field: Field): void {
    this.editionFieldUuid = undefined
    this.inEdit = false;
    this.modalRef.close()
    this.modalRef = undefined
    let indexInArray = _.findIndex(this.fields, {uuid: field.uuid})

    if (indexInArray != -1) {
      this.fields[indexInArray] = field;
    } else {
      this.fields.push(field)
    }
  }


  startEdit(field: Field, tpl) {
    this.editionFieldUuid = field.uuid
    this.inEdit = true
    this.modalRef = this.modalService.open(tpl)
  }

  delete(field: Field): void {
    if (confirm("Are you sure to delete field " + field.label)) {
      this.fieldService.deleteField(field.uuid).toPromise()
        .then(t => this.fields.splice(this.fields.indexOf(field), 1))
    }
  }
}
