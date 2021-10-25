import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {AnnexService, Item, ThumbnailService} from "../../../generated/api";
import {RxjsHelperService} from "../../rxjs-helper.service";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {CameraSnapshotComponent} from "../../camera-input/camera-snapshot/camera-snapshot.component";
import {ThumbnailImpl} from "../../model/ThumbnailImpl";

@Component({
  selector: 'app-thumbnail-camera',
  templateUrl: './thumbnail-camera.component.html',
  styleUrls: ['./thumbnail-camera.component.css']
})
export class ThumbnailCameraComponent implements OnInit {

  constructor(
    public r: RxjsHelperService,
    public activeModal: NgbActiveModal,
    public annexService: AnnexService,
    public thumbnailService: ThumbnailService,
  ) {
  }

  ngOnInit(): void {
  }

  @ViewChild('camera') camera: CameraSnapshotComponent

  @Input()
  item: Item;

  save(){
    this.camera.captureAsBlob().then(blob =>
      this.annexService.uploadFile(this.item.uuid, blob).toPromise())
      .then(v => this.thumbnailService.setDescription(this.item.uuid, new ThumbnailImpl(v.uuid)))
      .then(v => console.log("t", v))

  }
}
