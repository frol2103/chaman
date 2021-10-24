import {Event, Field, FieldConfig} from "../../generated/api";

export class EventImpl implements Event {
  /**
   * single uuid acrross all version of the field
   */
  constructor(
    public eventType?: Event.EventTypeEnum,
    public itemId: string = undefined,
    public content: string = undefined,
  ) {
  }

}
