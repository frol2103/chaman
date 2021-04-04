import {Injectable, TemplateRef} from '@angular/core';

@Injectable({providedIn: 'root'})
export class ToastService {
  toasts: any[] = [];

  show(textOrTpl: string | TemplateRef<any>, options: any = {}) {
    this.toasts.push({textOrTpl, ...options});
  }

  showError(text: string, error: any) {
    this.show(text, {classname: 'bg-danger text-light', delay: 10000})
  }

  showSuccess(text: string) {
    this.show(text, {classname: 'bg-success text-light', delay: 10000})
  }

  remove(toast) {
    this.toasts = this.toasts.filter(t => t !== toast);
  }
}
