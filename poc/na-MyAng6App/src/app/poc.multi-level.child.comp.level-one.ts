import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
    selector: 'child-one',
    template: `<b>Recv Message</b><br/>
				<div>
                    Message (child level one) : <input [value]="msgSibling" />
				</div>
                <br/>
                <child-two (sendMessageEvent)="message=$event"></child-two>`
})

export class MultiLevelChildComponentOne {    
	msgSibling:string='';
	set message(msg) {
		this.msgSibling=msg.text;
    }
}
