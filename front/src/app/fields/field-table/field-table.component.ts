import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Field} from "../../../generated/api";

@Component({
  selector: 'field-table',
  templateUrl: './field-table.component.html',
  styleUrls: ['./field-table.component.css']
})
export class FieldTableComponent implements OnInit {

  constructor() { }

  @Input() fields: Array<Field>
  @Input() allowEdit: boolean = false
  @Input() allowRemove: boolean = false

  @Output() editField = new EventEmitter<Field>();
  @Output() selectField = new EventEmitter<Field>();
  @Output() removeField = new EventEmitter<Field>();

  ngOnInit(): void {
  }

  actionEditField(field:Field) : void {
    this.editField.emit(field);
  }
  actionSelectField(field:Field) : void {
    this.selectField.emit(field);
  }
  actionRemoveField(field:Field) : void {
    this.removeField.emit(field);
  }

}
