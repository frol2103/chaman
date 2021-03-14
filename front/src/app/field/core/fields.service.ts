import { Injectable } from '@angular/core';
import {FieldParent} from './fieldParent';
import {StringComponent} from "../template/string/string.component";
import {IntegerComponent} from "../template/integer/integer.component";

@Injectable({
  providedIn: 'root'
})
export class FieldsService {

  fields = new Map();


  constructor() {
    this.fields.set("String", StringComponent)
    this.fields.set("Integer", IntegerComponent)
  }

  getFieldComponent(fieldType: string){
    return this.fields.get(fieldType);
  }
}
