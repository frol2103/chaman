import { Component, OnInit } from '@angular/core';
import {FieldParent} from "../../core/fieldParent";
import {Field} from "../../../../generated/api";

@Component({
  selector: 'app-string',
  templateUrl: './string.component.html',
  styleUrls: ['./string.component.css']
})
export class StringComponent extends FieldParent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit(): void {
  }


}
