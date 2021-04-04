import {Component, Input, OnInit} from '@angular/core';
import {Template} from "../../../../generated/api";

@Component({
  selector: 'app-template-table',
  templateUrl: './template-table.component.html',
  styleUrls: ['./template-table.component.css']
})
export class TemplateTableComponent implements OnInit {

  constructor() { }

  @Input() templates: Array<Template>

  ngOnInit(): void {
  }


}
