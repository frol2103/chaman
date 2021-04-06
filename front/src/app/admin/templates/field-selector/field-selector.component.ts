import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Field, FieldService} from "../../../../generated/api";

@Component({
  selector: 'app-field-selector',
  templateUrl: './field-selector.component.html',
  styleUrls: ['./field-selector.component.css']
})
export class FieldSelectorComponent implements OnInit {

  constructor(
    private fieldService : FieldService,
  ) { }


  @Output() selectField = new EventEmitter<Field>();

  fields = this.fieldService.getField().toPromise()

  ngOnInit(): void {
  }

  actionSelectField(field){
    this.selectField.emit(field)
  }

}
