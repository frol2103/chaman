import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Field, ItemService} from "../../../generated/api";
import {RxjsHelperService} from "../../rxjs-helper.service";

@Component({
  selector: 'app-field-savable',
  templateUrl: './field-savable.component.html',
  styleUrls: ['./field-savable.component.css']
})
export class FieldSavableComponent implements OnInit {

  constructor(
    private r: RxjsHelperService,
    private itemService: ItemService,
  ) {
  }

  @Input() showLabel = true
  @Input() itemUuid: string
  @Input() subReference: string
  @Input() field: Field
  @Input() inEdit: boolean
  @Output() onDelete = new EventEmitter<Field>()

  ngOnInit(): void {
  }

  save() {
    this.r.wrap(this.itemService.updateItemField(this.itemUuid, this.field.uuid, this.field, this.subReference))
      .withErrorMessage("Failed to update field")
      .withSuccessMessage("Field updated")
      .then(v => this.inEdit=false, v => this.field.errorMessages = v.error.content.errorMessages)
  }

  delete() {
    this.r.wrap(this.itemService.deleteItemField(this.itemUuid, this.field.uuid))
      .withErrorMessage("Failed to remove field")
      .withSuccessMessage("Field removed")
      .then(v => this.onDelete.emit(this.field))
  }

  startEdit() {
    this.inEdit = true;
  }
}
