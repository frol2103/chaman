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
    this.fields.set("string", StringComponent)
    this.fields.set("integer", IntegerComponent)
  }

  getFieldComponent(fieldType: string){
    return this.fields.get(fieldType);
  }
}
