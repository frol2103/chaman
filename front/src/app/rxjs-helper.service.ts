import {Injectable} from '@angular/core';
import {Observable, PartialObserver} from "rxjs";
import {ToastService} from "./toast/toast.service";

class RxjsHelperWrap<T> {
  constructor(
    private o: Observable<T>,
    private toastService: ToastService,
    private successMessage?: string,
    private errorMessage?: string,
  ) {
    o.subscribe()
  }

  withErrorMessage(errorMessage: string) {
    return new RxjsHelperWrap<T>(this.o,this.toastService, this.successMessage, errorMessage)
  }

  withSuccessMessage(successMessage: string) {
    return new RxjsHelperWrap<T>(this.o,this.toastService, successMessage, this.errorMessage)
  }

  then(callback: (t:T) => void) {
    this.o.toPromise()
      .then(v => {
          if (this.successMessage) {
            this.toastService.showSuccess(this.successMessage)
          }
          callback(v)
        }
      ).catch(e =>
      this.toastService.showError((this.errorMessage) ? this.errorMessage : "Error", e)
    )
  }
}

@Injectable({
  providedIn: 'root'
})
export class RxjsHelperService {

  constructor(
    private toast: ToastService,
  ) {
  }
  wrap<T>(o: Observable<T>) : RxjsHelperWrap<T>{
    return new RxjsHelperWrap<T>(o, this.toast)

  }
}
