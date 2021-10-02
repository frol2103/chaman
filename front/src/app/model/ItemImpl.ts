import {Field, Item} from "../../generated/api";

export class ItemImpl implements Item {
  /**
   * single uuid acrross all version of the field
   */
  constructor(
    public title: string = 'New item',
    public description: string = "",
    public content: Array<Field> = [],
  ) {
  }

}
