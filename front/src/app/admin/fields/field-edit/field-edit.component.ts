import {Component, Input, OnInit, Output, EventEmitter, ViewChild} from '@angular/core';
import {DatatypesService, Field, FieldService} from "../../../../generated/api";
import {FieldImpl} from "../../../model/FieldImpl";
import {ToastService} from "../../../toast/toast.service";
import {Subject} from "rxjs";
import {FieldDirective} from "../../../field/core/field.directive";
import {FieldComponent} from "../../../field/core/field/field.component";

@Component({
  selector: 'app-field-edit',
  templateUrl: './field-edit.component.html',
  styleUrls: ['./field-edit.component.css']
})
export class FieldEditComponent implements OnInit {

  constructor(
    private fieldService: FieldService,
    private datatypesService: DatatypesService,
    private toastService: ToastService,
  ) { }


  @Input() field : Field = new FieldImpl();

  @Output() fieldSaved = new EventEmitter<Field>();

  @ViewChild(FieldComponent) fieldComponent: FieldComponent;

  dataTypes = this.datatypesService.getDataTypes().toPromise()


  ngOnInit(): void {
  }

  submit(): void {
    ((this.field.uuid)? this.fieldService.updateField(this.field.uuid,this.field):this.fieldService.createField(this.field))
      .toPromise()
      .then(v => this.fieldSaved.emit(v))
      .catch(e =>  this.toastService.showError('Error while saving field',e) )
  }

  updateField(){
    this.field.value = undefined;
    if(this.fieldComponent){
      this.fieldComponent.refresh();
    }
  }

}
