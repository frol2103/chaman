import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Field} from "../../../../generated/api";

@Component({
  selector: 'field-table',
  templateUrl: './field-table.component.html',
  styleUrls: ['./field-table.component.css']
})
export class FieldTableComponent implements OnInit {

  constructor() { }

  @Input() fields: Array<Field>

  @Output() editField = new EventEmitter<Field>();

  ngOnInit(): void {
  }

  actionEditField(field:Field) : void {
    this.editField.emit(field);
  }

}
