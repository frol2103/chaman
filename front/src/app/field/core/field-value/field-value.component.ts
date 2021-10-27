import {Component, ComponentFactoryResolver, Input, OnInit, ViewChild} from '@angular/core';
import {Field, FieldValue} from "../../../../generated/api";
import {FieldDirective} from "../field.directive";
import {FieldParent} from "../fieldParent";
import {FieldsService} from "../fields.service";

@Component({
  selector: 'app-field-value',
  templateUrl: './field-value.component.html',
  styleUrls: ['./field-value.component.css']
})
export class FieldValueComponent implements OnInit {

  constructor(
    private fieldsService: FieldsService,
    private componentFactoryResolver: ComponentFactoryResolver
  ) { }

  fieldComponent : FieldParent;
  @Input() field: Field
  @ViewChild(FieldDirective, {static: true}) fieldDirective: FieldDirective;

  _inEdit:boolean = false;

  @Input() set inEdit(b:boolean){
    this._inEdit = b;
    if(this.fieldComponent) this.fieldComponent.inEdit = b
  }

  ngOnInit(): void {
    this.refresh()
  }

  refresh(): void{
    const fieldComponent = this.fieldsService.getFieldComponent(this.field.inputType);

    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(fieldComponent);

    const viewContainerRef = this.fieldDirective.viewContainerRef;
    viewContainerRef.clear();
    const componentRef = viewContainerRef.createComponent(componentFactory);
    this.fieldComponent = (<FieldParent>componentRef.instance)
    this.fieldComponent.field = this.field;
    this.fieldComponent.inEdit = this._inEdit;
  }

}
