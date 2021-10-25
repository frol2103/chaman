import {Autocomplete} from "../multiple-parent/autocomplete";
import {TagService} from "../../../../generated/api";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import { of } from 'rxjs/internal/observable/of';

export class TagAutocomplete implements Autocomplete{
  allTags : string[]

  constructor(
    public fieldUuid: string,
    public tagService: TagService,
  ){

  }


  getAllTags() : Observable<string[]>{
    if(this.allTags)
      return of(this.allTags)
    else
      return this.tagService.getAllTags(this.fieldUuid).pipe(
        map(v => {
          this.allTags = v
          return v
        })
      )
  }


  add(v: string): Observable<string> {
    if(confirm("Are you sure you want to add tag : " + v)){
      return this.tagService.addTag(this.fieldUuid, v).pipe(
        map(_ => v)
      )
    } else return of(undefined)
  }

  get(v: string): Observable<string[]> {
    if(!v) return this.getAllTags().pipe(map(v => v.slice()));
    const lowerCaseV = v.toLowerCase()
    return this.getAllTags().pipe(
      map( all => all.filter(i => i.toLowerCase().includes(lowerCaseV)))
    )
  }
}
