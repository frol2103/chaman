import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Field, Template} from "../../../../generated/api";

@Component({
  selector: 'app-template-table',
  templateUrl: './template-table.component.html',
  styleUrls: ['./template-table.component.css']
})
export class TemplateTableComponent implements OnInit {

  constructor() { }

  @Input() templates: Array<Template>
  @Output() removeTemplate = new EventEmitter<Template>();

  ngOnInit(): void {
  }

  remove(template:Template){
    this.removeTemplate.emit(template)
  }

}
