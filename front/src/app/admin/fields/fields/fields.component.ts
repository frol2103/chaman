import { Component, OnInit } from '@angular/core';
import {DatatypesService, Field, FieldService} from "../../../../generated/api";
import {Observable} from "rxjs";
import {FieldImpl} from "../../../model/FieldImpl";

@Component({
  selector: 'fields',
  templateUrl: './fields.component.html',
  styleUrls: ['./fields.component.css']
})
export class FieldsComponent implements OnInit {

  constructor(
    private fieldService: FieldService,
  ) { }

  fields: Array<Field>
  editionField : Field = new FieldImpl();

  ngOnInit(): void {
    this.fieldService.getField().toPromise().then(l => this.fields = l)
  }

  updateField(field : Field) : void {
    this.fields.push(field)
  }

}
