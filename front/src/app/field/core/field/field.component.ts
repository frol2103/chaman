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

  @ViewChild('valueInput') valueInput : ElementRef<HTMLInputElement>

  ngOnInit(): void {
  }


  startEdit() {
    this.edition = true

    setTimeout(()=>{ // this will make the execution after the above boolean has changed
      this.valueInput.nativeElement.focus();
    },0);
  }


  addValue(s: MatChipInputEvent) {
    if (s.value === "") {
      this.save()
    } else {
      if (!this.field.value) {
        this.field.value = []
      }
      this.field.value.push(new FieldValueImpl(null, {data: s.value}))
      s.input.value = "";
    }
  }

  remove(v: FieldValue) {
    this.field.value.splice(this.field.value.indexOf(v), 1)
  }

  deleteField() {
    if (confirm("Are you sure you want to delete the field : " + this.field.label + "?")) {
      this.onDelete.emit(this.field);
    }
  }

  save() {

    this.edition = false;
  }

  cancel() {
    this.edition = false;
    this.test = "ahah"
  }
}
