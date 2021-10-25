import { Component, OnInit } from '@angular/core';
import {FieldParent} from "../../core/fieldParent";
import {TagService} from "../../../../generated/api";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {TagAutocomplete} from "./tag-autocomplete";


@Component({
  selector: 'app-multiple-tag',
  templateUrl: './multiple-tag.component.html',
  styleUrls: ['./multiple-tag.component.css']
})
export class MultipleTagComponent extends FieldParent implements OnInit {

  constructor(
    private tagService: TagService,
  ) {
    super();
  }

  autocomplete: TagAutocomplete

  ngOnInit(): void {
    this.autocomplete = new TagAutocomplete(this.field.uuid, this.tagService)
  }

}
