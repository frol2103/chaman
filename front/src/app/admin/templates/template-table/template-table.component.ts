import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Field, Template, TemplateService} from "../../../../generated/api";

@Component({
  selector: 'app-template-table',
  templateUrl: './template-table.component.html',
  styleUrls: ['./template-table.component.css']
})
export class TemplateTableComponent implements OnInit {

  constructor(
    private templateService: TemplateService,
  ) { }

  @Input() templates: Array<Template>
  @Output() removeTemplate = new EventEmitter<Template>();
  @Output() selectTemplate = new EventEmitter<Template>();

  @Input() canRemove = false;
  @Input() canEdit = false;

  showActionCol() {
    return this.canRemove || this.canEdit
  }

  ngOnInit(): void {
    if(!this.templates){
      this.templateService.getTemplates().toPromise().then(l => this.templates = l)
    }
  }

  remove(template:Template){
    this.removeTemplate.emit(template)
  }

  select(template:Template){
    this.selectTemplate.emit(template)
  }

}
