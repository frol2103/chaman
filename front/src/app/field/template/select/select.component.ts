import { Component, OnInit } from '@angular/core';
import {FieldParent} from "../../core/fieldParent";

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent extends FieldParent implements OnInit {

  constructor() { super() }

  ngOnInit(): void {
  }

}
