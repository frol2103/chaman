import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Item, Link, LinkService} from "../../../../generated/api";
import {MatTableDataSource} from "@angular/material/table";
import {RxjsHelperService} from "../../../rxjs-helper.service";

@Component({
  selector: 'app-link-table',
  templateUrl: './link-table.component.html',
  styleUrls: ['./link-table.component.css']
})
export class LinkTableComponent implements OnInit {

  constructor(
    private linkService: LinkService,
    private r: RxjsHelperService,
  ) {
  }

  datasource = new MatTableDataSource<Link>()
  displayedColumns = ['title', 'description', 'actions']

  @Input() item: Item
  @Output() deleteLink = new EventEmitter<Link>();

  ngOnInit(): void {
    this.refresh()
  }

  refresh() {
    this.datasource.data = this.item.links;
  }

  delete(l: Link) {
    this.r.wrap(this.linkService.deleteLink(l.uuid))
      .withErrorMessage("Error while removing link")
      .then(v => this.deleteLink.emit(l))

  }
}
