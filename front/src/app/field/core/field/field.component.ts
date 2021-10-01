import {Component, ComponentFactoryResolver, Input, OnInit, ViewChild} from '@angular/core';
import {FieldsService} from "../fields.service";
import {FieldDirective} from "../field.directive";
import {FieldParent} from "../fieldParent";
import {Field, FieldValue} from "../../../../generated/api";
import {FieldValueImpl} from "../../../model/FieldValueImpl";

@Component({
  selector: 'app-field',
  templateUrl: './field.component.html',
  styleUrls: ['./field.component.css']
})
export class FieldComponent implements OnInit {

  constructor(
  ) {
  }


  @Input() field: Field
  @Input() showLabel: Boolean = true

  ngOnInit(): void {
  }


  addValue() {
    if(! this.field.value) { this.field.value = []}
    this.field.value.push(new FieldValueImpl(null, {data:""}))
  }

  remove(v: FieldValue) {
    this.field.value.splice(this.field.value.indexOf(v),1)

  }
}
