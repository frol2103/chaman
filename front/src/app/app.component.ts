import {Component} from '@angular/core';
import {WebsocketService} from "./websocket.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'chaman';

  constructor(
    private websocketService: WebsocketService,
  ) {
    let url = "ws://"+window.location.host+":"+9000+"/api/event/user";
    console.log("get events from", url)
    websocketService.connect(url).subscribe(v =>
      console.log("received event", JSON.parse(v.data))
    )
  }
}
