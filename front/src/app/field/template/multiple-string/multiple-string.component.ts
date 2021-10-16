import {Component, OnInit} from '@angular/core';
import {MatChipInputEvent} from "@angular/material/chips";
import {FieldValueImpl} from "../../../model/FieldValueImpl";
import {FieldValue} from "../../../../generated/api";
import {FieldParent} from "../../core/fieldParent";

@Component({
  selector: 'app-multiple-string',
  templateUrl: './multiple-string.component.html',
  styleUrls: ['./multiple-string.component.css']
})
export class MultipleStringComponent extends FieldParent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit(): void {
  }


}
