import { Component } from '@angular/core';
import { environment } from '../environments/environment';

import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import * as $ from 'jquery';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  private serverUrl:string = environment.serverUrl;
  private title = 'Group Chat Room';
  private stompClient = null;
  private username:string = '';
  private groupId:string = '';

  private colors:string[] = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
  ];

  constructor(){
  }
  
  connect(event) {
      let ws = new SockJS(this.serverUrl);
      this.stompClient = Stomp.over(ws);
      let that = this;
      this.stompClient.connect({}, function(frame) {
        that.stompClient.send("/app/chat.addUser" + "/" + that.groupId, 
            {}, 
            JSON.stringify(
                {'sender': that.username, 'type': 'JOIN', 'group': that.groupId}
            )
        );
      that.stompClient.subscribe("/chat" + "/" + that.groupId, (payload) => {   
      if(payload.body) {
          var usernamePage = document.querySelector('#username-page');
          var chatPage = document.querySelector('#chat-page');
          usernamePage.classList.add('hidden');
          chatPage.classList.remove('hidden');
          that.populateChatPage(payload);
        }
      });
    }, this.onError);
    $('.connecting').addClass('hidden');
  }
  
  sendMessage(event) {
    var messageInput = $('#message');
    var messageContent = messageInput.val();    
    if(messageContent && this.stompClient) {
        var chatMessage = {
            sender: this.username,
            content: messageInput.val(),
            type: 'CHAT',
            group: this.groupId
        };
        this.stompClient.send("/app/send/message" + "/" + this.groupId, {}, JSON.stringify(chatMessage));
        messageInput.val('');
    }
    event.preventDefault();
  }

  populateChatPage(payload) {
    if(payload.body) {
      let message = JSON.parse(payload.body);
      var messageElement = document.createElement('li');
      if(message) {
        var avatarColor = this.getAvatarColor(message.sender);

        if(message.type === 'JOIN') {
            messageElement.classList.add('event-message');
            message.content = message.sender + ' joined!';
            messageElement.style['font-weight'] = 'bold';
            messageElement.style['color'] = avatarColor;
            messageElement.style['float'] = 'right';
        } else if (message.type === 'LEAVE') {
            messageElement.classList.add('event-message');
            messageElement.style['float'] = 'right';
            message.content = message.sender + ' left!';
        } else { 
            messageElement.classList.add('chat-message');
            messageElement.style['line-height'] = '0.50';
            messageElement.style['margin-top'] = '10px';
            messageElement.style['margin-bottom'] = '10px';
            var usernameElement = document.createElement('span');
            usernameElement.style['font-weight'] = 'bold';
            usernameElement.style['color'] = avatarColor;
            var usernameText = document.createTextNode(message.sender + ": ");
            usernameElement.appendChild(usernameText);
            messageElement.appendChild(usernameElement);
        }
      }
      
      var textElement = document.createElement('span');
      textElement.style['line-height'] = '1';

      var messageArea = $('#messageArea');      
      var messageText = document.createTextNode(message.content);

      textElement.appendChild(messageText);
      messageElement.appendChild(textElement);
      messageArea.append(messageElement);
      messageArea.scrollTop($("#dvContent").prop("scrollHeight"));
      var connectingElement = $('.connecting');
      $('.connecting').addClass('hidden');
    }
  }

  onError(error) {
    alert("Error: \n\nCould not connect to WebSocket server. \nMake sure the server running and try again.\n\n");
  }

  getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % this.colors.length);
    return this.colors[index];  
  }
}
