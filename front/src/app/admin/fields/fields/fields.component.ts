import { Component, OnInit } from '@angular/core';
import {Field, FieldService} from "../../../../generated/api";
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

  fields: Observable<Array<Field>>
  editionField : Field = new FieldImpl();

  ngOnInit(): void {
    this.fields = this.fieldService.getField()
  }

  submit(): void {
    console.log("edition field", this.editionField)
    this.fieldService.createField(this.editionField)
      .toPromise()
      .then(v => {})
  }

}
