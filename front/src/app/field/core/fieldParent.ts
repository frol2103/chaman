import {Field, FieldValue} from "../../../generated/api";

export abstract class FieldParent {
  public _fieldValue: FieldValue;

  public set fieldValue(v) {
    this._fieldValue = v;
  }

  public get fieldValue() {
    return this._fieldValue;
  }

}
