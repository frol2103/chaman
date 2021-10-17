import { Injectable } from '@angular/core';
import {FieldParent} from './fieldParent';
import {StringComponent} from "../template/string/string.component";
import {IntegerComponent} from "../template/integer/integer.component";
import {SelectComponent} from "../template/select/select.component";
import {MultipleStringComponent} from "../template/multiple-string/multiple-string.component";
import {MultipleIntegerComponent} from "../template/multiple-integer/multiple-integer.component";

@Injectable({
  providedIn: 'root'
})
export class FieldsService {

  fields = new Map();


  constructor() {
    this.fields.set("string", StringComponent)
    this.fields.set("number", IntegerComponent)
    this.fields.set("select", SelectComponent)
    this.fields.set("multipleString", MultipleStringComponent)
    this.fields.set("multipleNumber", MultipleIntegerComponent)
  }

  getFieldComponent(fieldType: string){
    return this.fields.get(fieldType);
  }
}
