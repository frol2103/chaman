import {Component, Input, OnInit} from '@angular/core';
import {Field} from "../../../../generated/api";

@Component({
  selector: 'field-table',
  templateUrl: './field-table.component.html',
  styleUrls: ['./field-table.component.css']
})
export class FieldTableComponent implements OnInit {

  constructor() { }

  @Input() fields: Array<Field>

  ngOnInit(): void {
  }

}
