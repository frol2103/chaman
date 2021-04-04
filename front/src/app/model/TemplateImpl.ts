import {Field, Template} from "../../generated/api";

export class TemplateImpl implements Template {
  /**
   * single uuid acrross all version of the field
   */
  constructor(
    uuid?: string,
    parents?: Array<Template>,
    label?: string,
    reference?: string,
    content?: Array<Field>,
  ) {

  }
}
