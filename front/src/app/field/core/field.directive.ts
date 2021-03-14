import {Directive, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[fieldDirective]'
})
export class FieldDirective {
  constructor(public viewContainerRef: ViewContainerRef) { }
}
