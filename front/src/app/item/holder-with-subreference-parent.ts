import {Annex} from "../../generated/api";

export abstract class HolderWithSubReference {

  public displayedColumns = [];

  abstract updateDisplayedColumns(fieldCols : Array<string>)

  fields = {}

  get fieldsIds() {
    return Object.keys(this.fields)
  }


  getFieldName(uuid:string){
    return this.fields[uuid]
  }
}
