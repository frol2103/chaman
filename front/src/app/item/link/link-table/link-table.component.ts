import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Annex, Item, Link, LinkService} from "../../../../generated/api";
import {MatTableDataSource} from "@angular/material/table";
import {RxjsHelperService} from "../../../rxjs-helper.service";
import {HolderWithSubReference} from "../../holder-with-subreference-parent";

@Component({
  selector: 'app-link-table',
  templateUrl: './link-table.component.html',
  styleUrls: ['./link-table.component.css']
})
export class LinkTableComponent extends HolderWithSubReference implements OnInit {
  private displayedColumns = [];

  constructor(
    private linkService: LinkService,
    private r: RxjsHelperService,
  ) {
    super()
  }

  datasource = new MatTableDataSource<Link>()

  @Input() item: Item
  @Output() deleteLink = new EventEmitter<Link>();

  ngOnInit(): void {
    this.refresh()
  }


  getField(f:Link, uuid:string) {
    return f.fields.find(v => v.uuid === uuid)
  }

  updateDisplayedColumns(fieldCols : Array<string>) {
    this.displayedColumns = ['title', 'description'].concat(fieldCols, ['actions'])
  }

  refresh() {
    this.datasource.data = this.item.links;
    this.item.links.flatMap(v => v.fields).forEach(v=>
      this.fields[v.uuid] = v.label
    )
    this.updateDisplayedColumns(this.fieldsIds)
  }

  delete(l: Link) {
    this.r.wrap(this.linkService.deleteLink(l.uuid))
      .withErrorMessage("Error while removing link")
      .then(v => this.deleteLink.emit(l))

  }
}
