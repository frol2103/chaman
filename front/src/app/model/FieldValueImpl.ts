import {Field, FieldValue} from "../../generated/api";

export class FieldValueImpl implements FieldValue {
  /**
   * single uuid acrross all version of the field
   */
  constructor(
    public uuid?: string,
    public value?: any,
  ) {
  }

}
