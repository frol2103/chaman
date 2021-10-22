import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Item, Thumbnail, ThumbnailService} from "../../../generated/api";
import {RxjsHelperService} from "../../rxjs-helper.service";
import {ImageCropperComponent} from "../../image-cropper/image-cropper.component";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-thumbnail-editor',
  templateUrl: './thumbnail-editor.component.html',
  styleUrls: ['./thumbnail-editor.component.css']
})
export class ThumbnailEditorComponent implements OnInit {
  private thumbnailDescription: Thumbnail;

  constructor(
    public r: RxjsHelperService,
    public thumbnailService: ThumbnailService,
    public activeModal: NgbActiveModal
  ) {
  }

  @ViewChild("imgCropper", {'static': false})
  imageCropper: ImageCropperComponent;

  @Input()
  item: Item;

  ngOnInit(): void {
    this.r.wrap(this.thumbnailService.getDescription(this.item.uuid))
      .withErrorMessage("couldn't get icon description")
      .then(v => this.thumbnailDescription = v)

  }

  save() {
    let infos = this.imageCropper.getInfos();
    this.thumbnailDescription.x = infos.x
    this.thumbnailDescription.y = infos.y
    this.thumbnailDescription.width = infos.width

    this.r.wrap(this.thumbnailService.setDescription(this.item.uuid,this.thumbnailDescription))
      .withSuccessMessage("Icon updated")
      .withErrorMessage("Error while saving icon")
      .then(v => this.activeModal.close(v))
  }
}
