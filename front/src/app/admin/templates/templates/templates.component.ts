import { Component, OnInit } from '@angular/core';
import {Template, TemplateService} from "../../../../generated/api";

@Component({
  selector: 'app-templates',
  templateUrl: './templates.component.html',
  styleUrls: ['./templates.component.css']
})
export class TemplatesComponent implements OnInit {

  constructor(
    private templateService: TemplateService,
  ) { }

  templates: Array<Template>

  ngOnInit(): void {
    this.templateService.getTemplates().toPromise().then(l => this.templates = l)
  }



}
