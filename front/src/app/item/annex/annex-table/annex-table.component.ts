import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Annex, AnnexService, Thumbnail, ThumbnailService} from "../../../../generated/api";
import {RxjsHelperService} from "../../../rxjs-helper.service";
import {MatTableDataSource} from "@angular/material/table";
import {ThumbnailImpl} from "../../../model/ThumbnailImpl";

@Component({
  selector: 'app-annex-table',
  templateUrl: './annex-table.component.html',
  styleUrls: ['./annex-table.component.css']
})
export class AnnexTableComponent implements OnInit {

  constructor(
    private r: RxjsHelperService,
    private annexService: AnnexService,
    private thumbnailService: ThumbnailService,
  ) {
  }

  @Input() annexes: Array<Annex>
  @Input() itemUuid: string
  @Output() deleteAnnex = new EventEmitter<Annex>()
  @Output() setThumbnail = new EventEmitter<Thumbnail>()

  datasource = new MatTableDataSource<Annex>()

  displayedColumns = ['name', 'actions']

  ngOnInit(): void {
    this.refresh()
  }

  refresh() {
    this.datasource.data = this.annexes;

  }

  delete(f: Annex) {
    if (confirm("Are you sure you want to delete annex " + f.filename)) {
      this.r.wrap(this.annexService.deleteAnnex(f.uuid))
        .withErrorMessage("Failed to remove annex")
        .then(v => this.deleteAnnex.emit(f))
    }
  }

  thumbnail(f: Annex) {
    this.r.wrap(this.thumbnailService.setDescription(this.itemUuid, new ThumbnailImpl(f.uuid)))
      .withSuccessMessage("Thumbnail set")
      .withErrorMessage("Failed to set thumbnail")
      .then(v => this.setThumbnail.emit(v))

  }
}
