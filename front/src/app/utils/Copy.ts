export class Copy {
  static copy(v:any) : any {
    return JSON.parse(JSON.stringify(v));
  }
}
