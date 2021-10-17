import {Field, FieldValue} from "../../../generated/api";
import {FieldValueImpl} from "../../model/FieldValueImpl";

export abstract class FieldParent {
  public field: Field;

  public get fieldValue() : FieldValue{
    if(!this.field.value) this.field.value = []
    if(this.field.value.length === 0) this.field.value.push(new FieldValueImpl(undefined, undefined))
    return this.field.value[0];
  }

  public get fieldValues() {
    if(!this.field.value) this.field.value = []
    return this.field.value;
  }

}
