import { Component } from '@angular/core';
import { environment } from '../environments/environment';

import * as Stomp from '@stomp/stompjs'; 
import * as SockJS from 'sockjs-client'; 

@Component({
  selector: 'app-root',
  templateUrl: './poc.ang-wsock.spring.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private serverUrl:string = environment.serverUrl;
  private title:string = 'Angular 6 WebSocket';
  private description:string = 'WebSocket with Angular 6 and Spring Boot App';
 
  replies: string[] = [];
  private disabled:boolean = true;
  private text: string;
  private stompClient = null;
 
  constructor() {}
 
  setConnected(connected: boolean) {
    this.disabled = !connected;
    if (connected) {
      this.replies = [];
    }
  }
 
  connect() {
    const socket = new SockJS(this.serverUrl);
    this.stompClient = Stomp.Stomp.over(socket);
    const _this = this;
    this.stompClient.connect({}, function (frame) {
      _this.setConnected(true);
      console.log('Connected: ' + frame);
 
      _this.stompClient.subscribe('/reply/send', function (response) {
        _this.showGreeting(JSON.parse(response.body).text);
      });
    });
  }
 
  disconnect() {
    if (this.stompClient != null) {
      this.stompClient.disconnect();
    }
 
    this.setConnected(false);
    console.log('Disconnected!');
  }
 
  sendMessage() {
    this.stompClient.send(
      '/ang/recv',
      {},
      JSON.stringify({ 'text': this.text })
    );
  }
 
  showGreeting(message) {
    this.replies.push(message);
  }
}
