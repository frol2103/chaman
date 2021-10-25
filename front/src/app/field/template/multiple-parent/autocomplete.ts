import {Observable} from "rxjs";

export interface Autocomplete {
  get(v:string): Observable<string[]>

  add(v:string): Observable<string>
}
