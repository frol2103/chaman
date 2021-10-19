import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Annex, AnnexService} from "../../../../generated/api";
import {RxjsHelperService} from "../../../rxjs-helper.service";

@Component({
  selector: 'app-annex-table',
  templateUrl: './annex-table.component.html',
  styleUrls: ['./annex-table.component.css']
})
export class AnnexTableComponent implements OnInit {

  constructor(
    private r : RxjsHelperService,
    private annexService: AnnexService,
  ) { }

  @Input() annexes:Array<Annex>
  @Output() deleteAnnex = new EventEmitter<Annex>()

  displayedColumns = ['name', 'actions']

  ngOnInit(): void {
  }

  delete(f: Annex) {
    if(confirm("Are you sure you want to delete annex " + f.filename)){
      this.r.wrap(this.annexService.deleteAnnex(f.uuid))
        .withErrorMessage("Failed to remove annex")
        .then(v => this.deleteAnnex.emit(v))
    }

  }
}
