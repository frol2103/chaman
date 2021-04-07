import {Component, OnInit} from '@angular/core';
import {Template, TemplateService} from "../../../../generated/api";

@Component({
  selector: 'app-templates',
  templateUrl: './templates.component.html',
  styleUrls: ['./templates.component.css']
})
export class TemplatesComponent implements OnInit {

  constructor(
    private templateService: TemplateService,
  ) {
  }

  templates: Array<Template>

  ngOnInit(): void {
    this.templateService.getTemplates().toPromise().then(l => this.templates = l)
  }

  delete(template: Template): void {
    if (confirm("Are you sure to delete template " + template.label)) {
      this.templateService.deleteTemplate(template.uuid).toPromise()
        .then(t => this.templates.splice(this.templates.indexOf(template), 1))
    }
  }


}
