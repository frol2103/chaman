import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Template, TemplateService} from "../../../../generated/api";
import {map, mergeMap} from "rxjs/operators";
import {BehaviorSubject} from "rxjs";
import {TemplateImpl} from "../../../model/TemplateImpl";

@Component({
  selector: 'app-template-edit',
  templateUrl: './template-edit.component.html',
  styleUrls: ['./template-edit.component.css']
})
export class TemplateEditComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private templateService: TemplateService,
  ) {
  }

  id: string
  template: Template


  ngOnInit(): void {
    console.log("init")
    this.route.params.pipe(
      map(params => params.id)
    ).subscribe(v => {
      console.log("template for", v)
      if (v == "new") {
        this.template =new TemplateImpl();
      } else return this.templateService.getTemplate(v).toPromise().then(t => this.template = t)
    })
  }

  save(){
    if(this.template.uuid){
      this.templateService.updateTemplate(this.template.uuid, this.template).toPromise()
    } else {
      console.log("save")
      this.templateService.createTemplate(this.template).toPromise().then(v => console.log(v))
    }
  }
}
