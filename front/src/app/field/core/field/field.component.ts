import {Component, ComponentFactoryResolver, Input, OnInit, ViewChild} from '@angular/core';
import {FieldsService} from "../fields.service";
import {FieldDirective} from "../field.directive";
import {FieldParent} from "../fieldParent";
import {Field} from "../../../../generated/api";

@Component({
  selector: 'app-field',
  templateUrl: './field.component.html',
  styleUrls: ['./field.component.css']
})
export class FieldComponent implements OnInit {

  constructor(
    private fieldsService: FieldsService,
    private componentFactoryResolver: ComponentFactoryResolver
  ) {
  }


  @Input() field: Field
  @ViewChild(FieldDirective, {static: true}) fieldDirective: FieldDirective;

  ngOnInit(): void {
    this.refresh()
  }

  refresh(): void{

    const fieldComponent = this.fieldsService.getFieldComponent(this.field.dataType);

    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(fieldComponent);

    const viewContainerRef = this.fieldDirective.viewContainerRef;
    viewContainerRef.clear();
    const componentRef = viewContainerRef.createComponent(componentFactory);
    if(!this.field.value){
      this.field.value = {"data":null}
    }
    (<FieldParent>componentRef.instance).field = this.field;
  }
}
