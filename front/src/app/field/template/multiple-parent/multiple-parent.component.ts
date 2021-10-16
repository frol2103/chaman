import {Component, Input, OnInit} from '@angular/core';
import {MatChipInputEvent} from "@angular/material/chips";
import {FieldValueImpl} from "../../../model/FieldValueImpl";
import {Field, FieldValue} from "../../../../generated/api";

@Component({
  selector: 'app-multiple-parent',
  templateUrl: './multiple-parent.component.html',
  styleUrls: ['./multiple-parent.component.css']
})
export class MultipleParentComponent implements OnInit {

  constructor() {
  }

  @Input() field: Field;

  ngOnInit(): void {
  }

  addValue(s: MatChipInputEvent) {
    if (!this.field.value) {
      this.field.value = []
    }
    this.field.value.push(new FieldValueImpl(null, {data: s.value}))
    s.input.value = "";
  }

  remove(v: FieldValue) {
    this.field.value.splice(this.field.value.indexOf(v), 1)
  }
}
