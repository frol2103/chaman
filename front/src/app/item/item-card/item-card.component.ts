import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {
  Annex,
  AnnexService,
  Field,
  Item,
  ItemService,
  Event,
  EventService, Link, LinkService
} from "../../../generated/api";
import {ItemImpl} from "../../model/ItemImpl";
import {map, timestamp} from "rxjs/operators";
import {RxjsHelperService} from "../../rxjs-helper.service";
import {NgbModal, NgbModalConfig} from "@ng-bootstrap/ng-bootstrap";
import {FieldSelectorComponent} from "../../fields/field-selector/field-selector.component";
import {AnnexTableComponent} from "../annex/annex-table/annex-table.component";
import {ThumbnailEditorComponent} from "../thumbnail-editor/thumbnail-editor.component";
import {BehaviorSubject} from "rxjs";
import {EventImpl} from "../../model/EventImpl";
import {MobileDetectorService} from "../../mobile-detector.service";
import {CameraSnapshotComponent} from "../../camera-input/camera-snapshot/camera-snapshot.component";
import {ThumbnailCameraComponent} from "../thumbnail-camera/thumbnail-camera.component";
import {ItemSelectorComponent} from "../item-selector/item-selector.component";
import {LinkTableComponent} from "../link/link-table/link-table.component";
import {Location} from "@angular/common";

@Component({
  selector: 'app-item-card',
  templateUrl: './item-card.component.html',
  styleUrls: ['./item-card.component.css']
})
export class ItemCardComponent implements OnInit {

  item: Item

  constructor(
    public route: ActivatedRoute,
    private itemService: ItemService,
    private r: RxjsHelperService,
    private modalService: NgbModal,
    private annexService: AnnexService,
    private modalConfig: NgbModalConfig,
    private eventService: EventService,
    public mobileService: MobileDetectorService,
    public location: Location,
    public linkService: LinkService,
  ) {
    route.params.subscribe(p => {
        if (p.id === 'new') {
          this.item = new ItemImpl()
        }
        else {
          itemService.getItem(p.id).toPromise().then(i => {
            this.item = i
            this.refreshThumbnail()
          })
        }

      }
    )
    this.modalConfig.size = 'xl'
  }

  imgSrc: BehaviorSubject<string> = new BehaviorSubject(undefined);

  @ViewChild("annexTable") annexTable:AnnexTableComponent;
  @ViewChild("linkTable") linkTable:LinkTableComponent;

  ngOnInit(): void {

  }



  startAddField(){
    if(!this.item.content) this.item.content = []
    this.modalService.open(FieldSelectorComponent).result.then((result) => {
      this.item.content.push(result)
    });
  }

  deleteField(field: Field){
    this.item.content.splice(this.item.content.indexOf(field),1)
  }

  dlSticker() {
    window.location.href = "/api/item/" + this.item.uuid + "/sticker"
  }

  onFileChange(event: any) {
    this.r.wrap(this.annexService.uploadFile(this.item.uuid,event.target.files[0]))
      .withErrorMessage("Error while adding annex")
      .withSuccessMessage("Annex added")
      .then(v => {
        this.item.annexes.push(v)
        this.annexTable.refresh();
      })
  }

  annexDeleted(a:Annex) {
    this.item.annexes.splice(this.item.annexes.indexOf(a))
    this.annexTable.refresh()
  }


  refreshThumbnail(){
    this.imgSrc.next("/api/item/" + this.item.uuid + "/thumbnail/file?ts=" + Date.now())
  }

  editThumbnail() {
    let ngbModalRef = this.modalService.open(ThumbnailEditorComponent);
    ngbModalRef.componentInstance.item = this.item;
    ngbModalRef.result.then(v => this.refreshThumbnail())
  }

  requestPicture() {
    let eventImpl = new EventImpl(Event.EventTypeEnum.TakePicture, this.item.uuid);
    console.log("push event", eventImpl)
    this.r.wrap(this.eventService.addEvent(eventImpl))
      .withErrorMessage("Couldn't request a picture")
      .withSuccessMessage("Picture requested")
      .then(v => console.log("v"))

  }

  takePhoto() {
    let ngbModalRef = this.modalService.open(ThumbnailCameraComponent);
    ngbModalRef.componentInstance.item = this.item;
    ngbModalRef.result.then(v => this.refreshThumbnail())
  }

  addLink() {
    if(!this.item.links) this.item.links = []
    this.modalService.open(ItemSelectorComponent).result.then((result) => {
      this.linkService.addLink(this.item.uuid, result.uuid).toPromise().then( r => {
          this.item.links.push(r)
          this.linkTable.refresh()
      })
    });
  }

  linkDeleted(l:Link) {
    this.item.links.splice(this.item.links.indexOf(l))
    this.linkTable.refresh()
  }
}
