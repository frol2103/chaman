import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {DatatypesService, Field, FieldConfig, FieldService} from "../../../../generated/api";
import {ToastService} from "../../../toast/toast.service";
import {FieldComponent} from "../../../field/core/field/field.component";
import {Copy} from "../../../utils/Copy";
import {FieldConfigImpl} from "../../../model/FielConfigImpl";

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
  ) {
  }


  @Input() uuid: string;

  field: FieldConfig = new FieldConfigImpl();

  @Output() fieldSaved = new EventEmitter<Field>();

  @ViewChild(FieldComponent) fieldComponent: FieldComponent;

  dataTypes = this.datatypesService.getDataTypes().toPromise()


  ngOnInit(): void {
    this.updateField()
    if(this.uuid){
      this.fieldService.getFieldConfig(this.uuid).toPromise().then(v => this.field = v)
    } else {
      this.field = new FieldConfigImpl();
    }
  }

  submit(): void {
    ((this.uuid) ? this.fieldService.updateField(this.uuid, this.field) : this.fieldService.createField(this.field))
      .toPromise()
      .then(v => this.fieldSaved.emit(v))
      .catch(e => {
        this.field = e.error.content
        this.toastService.showError('Error while saving field', e)
      })
  }

  updateField() {
    this.dataTypes.then(v => {

      let typeConfig = v.find(d => d.datatype === this.field?.datatype);
      this.field.config = (typeConfig)?Copy.copy(typeConfig?.config):[];
    })
  }
}
