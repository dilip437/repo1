import {Component, EventEmitter, Input, Output} from '@angular/core';
import {MessageDTO} from './poc.message.dto';

@Component({
    selector: 'child-one',
    template: `<b>Send Message</b><br/>
				<div>
                    Message (child one) : <input [value]="msgSibling" 
                                            (input)="message.text=$event.target.value" />
                    &nbsp;
                    <button (click)="sendMessage()">Send</button>
				</div>`
})

export class SiblingChildOneComponent {
    @Input('msgSibling')
	msgSibling:string;
    
  	@Output('sendMessageEvent')
    messageEvent=new EventEmitter<MessageDTO>();
	
	message=new MessageDTO();
	sendMessage() {
		this.messageEvent.emit(this.message);
    }		
}
