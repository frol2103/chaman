import { Component, OnInit } from '@angular/core';
import {Field, FieldValue} from "../../../../generated/api";
import {FieldParent} from "../../core/fieldParent";

@Component({
  selector: 'app-integer',
  templateUrl: './integer.component.html',
  styleUrls: ['./integer.component.css']
})
export class IntegerComponent extends FieldParent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit(): void {
  }

}
