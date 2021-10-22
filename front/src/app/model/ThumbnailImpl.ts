import {Thumbnail} from "../../generated/api";

export class ThumbnailImpl implements Thumbnail {

  constructor(
    public annexUuid?: string,
    public x: number = undefined,
    public y: number = undefined,
    public width: number = undefined
  ) {
  }

}
