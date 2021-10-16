import { Component, OnInit } from '@angular/core';
import {FieldParent} from "../../core/fieldParent";

@Component({
  selector: 'app-multiple-integer',
  templateUrl: './multiple-integer.component.html',
  styleUrls: ['./multiple-integer.component.css']
})
export class MultipleIntegerComponent extends FieldParent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit(): void {
  }

}
