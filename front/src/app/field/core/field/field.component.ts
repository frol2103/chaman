import {Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Field, FieldValue} from "../../../../generated/api";
import {FieldValueImpl} from "../../../model/FieldValueImpl";
import {MatChipInputEvent} from "@angular/material/chips";

@Component({
  selector: 'app-field',
  templateUrl: './field.component.html',
  styleUrls: ['./field.component.css']
})
export class FieldComponent implements OnInit {

  constructor() {
  }

  edition = false

  @Input() field: Field
  @Input() showLabel: Boolean = true
  @Output() onDelete = new EventEmitter<Field>()


  ngOnInit(): void {
  }

}
