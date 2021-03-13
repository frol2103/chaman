import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {DatatypesService, Field, FieldService} from "../../../../generated/api";
import {FieldImpl} from "../../../model/FieldImpl";

@Component({
  selector: 'app-field-edit',
  templateUrl: './field-edit.component.html',
  styleUrls: ['./field-edit.component.css']
})
export class FieldEditComponent implements OnInit {

  constructor(
    private fieldService: FieldService,
    private datatypesService: DatatypesService,
  ) { }


  @Input() field : Field = new FieldImpl();

  @Output() fieldSaved = new EventEmitter<Field>();

  dataTypes = this.datatypesService.getDataTypes().toPromise()

  ngOnInit(): void {
  }

  submit(): void {
    this.fieldService.createField(this.field)
      .toPromise()
      .then(v => this.fieldSaved.emit(v))
  }

}
