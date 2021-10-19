import {Component, Input, OnInit} from '@angular/core';
import {Annex} from "../../../../generated/api";

@Component({
  selector: 'app-annex-table',
  templateUrl: './annex-table.component.html',
  styleUrls: ['./annex-table.component.css']
})
export class AnnexTableComponent implements OnInit {

  constructor() { }

  @Input() annexes:Array<Annex>

  displayedColumns = ['name', 'actions']

  ngOnInit(): void {
  }

}
