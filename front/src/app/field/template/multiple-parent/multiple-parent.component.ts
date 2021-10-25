import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {MatChipInputEvent} from "@angular/material/chips";
import {FieldValueImpl} from "../../../model/FieldValueImpl";
import {Field, FieldValue} from "../../../../generated/api";
import {MatAutocompleteSelectedEvent} from "@angular/material/autocomplete";
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs";
import {mergeMap, startWith} from "rxjs/operators";
import {Autocomplete} from "./autocomplete";

@Component({
  selector: 'app-multiple-parent',
  templateUrl: './multiple-parent.component.html',
  styleUrls: ['./multiple-parent.component.css']
})
export class MultipleParentComponent implements OnInit {

  constructor() {

  }

  filteredInputs: Observable<string[]>;

  @Input() field: Field;
  @Input() autoComplete: Autocomplete

  @ViewChild('valueInput') valueInput: ElementRef<HTMLInputElement>;

  inputCtrl = new FormControl();

  ngOnInit(): void {
    if (this.autoComplete) {
      this.filteredInputs = this.inputCtrl.valueChanges.pipe(
        startWith(null),
        mergeMap((v: string | null) => this._filter(v)));
    }
  }

  addValue(s: MatChipInputEvent) {
    if (s.value != "") {

      if (!this.field.value) {
        this.field.value = []
      }
      this.autoComplete.add(s.value).toPromise().then(v => {
        if (v) this.add(s.value);
        s.input.value = "";
      })
    }
  }

  private add(s: string) {
    this.field.value.push(new FieldValueImpl(null, {'strValue': s}))
  }

  remove(v: FieldValue) {
    this.field.value.splice(this.field.value.indexOf(v), 1)
  }


  selected(event: MatAutocompleteSelectedEvent): void {
    this.add(event.option.viewValue)
    this.valueInput.nativeElement.value = '';
    this.inputCtrl.setValue(null);
  }

  private _filter(v: string): Observable<string[]> {
    return this.autoComplete.get(v)
  }
}
