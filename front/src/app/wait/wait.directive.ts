import {ComponentFactoryResolver, Directive, ElementRef, Input, TemplateRef, ViewContainerRef} from '@angular/core';
import {WaitComponent} from "./wait.component";

@Directive({
  selector: '[wait]'
})
export class WaitDirective {

  previousState: boolean

  constructor(
    private element: ElementRef,
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef,
    private componentFactoryResolver: ComponentFactoryResolver,
  ) {
  }


  @Input()
  set wait(v: any) {
    if (v && this.previousState!==true) {
      this.previousState = true
      this.viewContainer.clear();
      this.viewContainer.createEmbeddedView(this.templateRef);
    } else if(!this.previousState) {
      this.previousState = false
      this.viewContainer.clear();
      const componentFactory = this.componentFactoryResolver.resolveComponentFactory(WaitComponent);
      const componentRef = this.viewContainer.createComponent<WaitComponent>(componentFactory);
    }
  }


}
