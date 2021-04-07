import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Field, Template, TemplateService} from "../../../../generated/api";
import {first, map} from "rxjs/operators";
import {TemplateImpl} from "../../../model/TemplateImpl";
import {RxjsHelperService} from "../../../rxjs-helper.service";

@Component({
  selector: 'app-template-edit',
  templateUrl: './template-edit.component.html',
  styleUrls: ['./template-edit.component.css']
})
export class TemplateEditComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private templateService: TemplateService,
    private r: RxjsHelperService,
  ) {
  }

  id: string
  template?: Template

  selectField = false;


  ngOnInit(): void {
    this.route.params.pipe(
      map(params => params.id),
      first()
    ).toPromise().then(v => {
      if (v == "new") {
        this.template = new TemplateImpl();
      } else return this.templateService.getTemplate(v).toPromise().then(t => this.template = t)
    })
  }

  save() {
    this.r.wrap((this.template.uuid) ?
      this.templateService.updateTemplate(this.template.uuid, this.template) :
      this.templateService.createTemplate(this.template))
      .withErrorMessage("Error while saving template")
      .withSuccessMessage("Template saved")
      .then(v => this.template = v)
  }

  startAddField(){
    this.selectField = true
  }

  addField(field : Field) {
    this.template.content.push(field)
    this.selectField = false
  }

  deleteField(field: Field){
    this.template.content.splice(this.template.content.indexOf(field),1)
  }
}
