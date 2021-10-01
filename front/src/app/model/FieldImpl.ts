import {Field} from "../../generated/api";

export class FieldImpl implements Field {
  /**
   * single uuid acrross all version of the field
   */
  constructor(
    public uuid?: string,
    public label?: string,
    public reference?: string,
    public dataType?: string,
    public value?: [],
  ) {
  }

  withDataType(dataType:string) : FieldImpl {
    this.dataType = dataType;
    return this
  }
}
