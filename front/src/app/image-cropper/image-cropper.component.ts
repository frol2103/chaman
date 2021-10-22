import {AfterViewInit, Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';

import Cropper from "cropperjs";
import {Thumbnail} from "../../generated/api";

@Component({
  selector: 'image-cropper',
  templateUrl: './image-cropper.component.html',
  styleUrls: ['./image-cropper.component.css']
})
export class ImageCropperComponent implements OnInit, AfterViewInit {

  @Input() thumbnail:Thumbnail;

  @ViewChild("image", {static : false})
  public imageElement: ElementRef;

  cropper: Cropper;

  constructor() { }


  ngOnInit(): void {
  }

  getInfos() {
    let cb = this.cropper.getCropBoxData();
    let ratio = this.cropper.getImageData().width / this.cropper.getImageData().naturalWidth;

    return {
      x: (cb.left / ratio),
      y: (cb.top / ratio),
      width:(cb.width / ratio),
    }
  }

  ngAfterViewInit(): void {
    this.cropper = new Cropper(this.imageElement.nativeElement,{
      zoomable: false,
      scalable: false,
      aspectRatio: 1,
      viewMode: 2,
      data:{
        x:this.thumbnail.x,
        y:this.thumbnail.y,
        width: this.thumbnail.width,
      }
    })
  }

}
