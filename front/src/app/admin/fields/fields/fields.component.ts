import {Component, OnInit} from '@angular/core';
import {Field, FieldService} from "../../../../generated/api";
import {FieldImpl} from "../../../model/FieldImpl";
import * as _ from 'lodash';

@Component({
  selector: 'fields',
  templateUrl: './fields.component.html',
  styleUrls: ['./fields.component.css']
})
export class FieldsComponent implements OnInit {

  constructor(
    private fieldService: FieldService,
  ) {
  }

  fields: Array<Field>
  editionField: Field

  ngOnInit(): void {
    this.fieldService.getField().toPromise().then(l => this.fields = l)
  }

  newField() {
    this.editionField = new FieldImpl();
  }

  fieldUpdated(field: Field): void {
    this.editionField = undefined
    let indexInArray = _.findIndex(this.fields, {uuid: field.uuid})
    console.log("indexInArray", indexInArray)
    if (indexInArray != -1) {
      this.fields[indexInArray] = field;
    } else {
      this.fields.push(field)
    }
  }


  startEdit(field: Field) {
    this.editionField = (JSON.parse(JSON.stringify(field)));
  }

  delete(field: Field): void {
    if (confirm("Are you sure to delete field " + field.label)) {
      this.fieldService.deleteField(field.uuid).toPromise()
        .then(t => this.fields.splice(this.fields.indexOf(field), 1))
    }
  }
}
