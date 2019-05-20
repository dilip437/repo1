import {Component, EventEmitter, Input, Output} from '@angular/core';
import {MessageDTO} from './poc.message.dto';

@Component({
    selector: 'child-two',
    template: `<b>Send Message</b><br/>
				       <div>
                    Message (child level two) : <input  
                                            (input)="message.text=$event.target.value" />
                    &nbsp;
                    <button (click)="sendMessage()">Send</button>
               </div>`
})

export class MultiLevelChildComponentTwo {    
  	@Output('sendMessageEvent')
    messageEvent=new EventEmitter<MessageDTO>();
	  message=new MessageDTO();
    sendMessage() {
		  this.messageEvent.emit(this.message);
    }		
}
