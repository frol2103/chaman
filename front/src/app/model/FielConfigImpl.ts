import {Field, FieldConfig} from "../../generated/api";

export class FieldConfigImpl implements FieldConfig {
  /**
   * single uuid acrross all version of the field
   */
  constructor(
    public label?: string,
    public reference?: string,
    public dataType?: string,
    public config?: Array<Field>,
  ) {
  }

}
