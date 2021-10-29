import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Annex, AnnexService, Thumbnail, ThumbnailService} from "../../../../generated/api";
import {RxjsHelperService} from "../../../rxjs-helper.service";
import {MatTableDataSource} from "@angular/material/table";
import {ThumbnailImpl} from "../../../model/ThumbnailImpl";
import {FieldImpl} from "../../../model/FieldImpl";

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
  fields = {}

  ngOnInit(): void {
    this.refresh()
  }

  updateDisplayedColumns(fieldCols : Array<string>) {
    this.displayedColumns = ['name'].concat(fieldCols, ['actions'])
  }

  refresh() {
    this.datasource.data = this.annexes;
    this.annexes.flatMap(v => v.fields).forEach(v=>
      this.fields[v.uuid] = v.label
    )
    this.updateDisplayedColumns(this.fieldsIds)
  }

  get fieldsIds() {
    return Object.keys(this.fields)
  }

  getField(f:Annex, uuid:string) {
    return f.fields.find(v => v.uuid === uuid)
  }

  getFieldName(uuid:string){
    return this.fields[uuid]
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
