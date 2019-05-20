import {Component} from '@angular/core';

@Component({
    selector: 'input-output',
	template: `<h3>Passing data between Sibling component  using @Input and @Output</h3>
				<child-one [msgSibling]="msgSibling"					
				    (sendMessageEvent)="message=$event" >
                </child-one>
                <br/> 
                <child-two [msgSibling]="msgSibling" 						
                    (sendMessageEvent)="message=$event" >
                </child-two>`
})

export class SiblingParentComponent {    
	msgSibling='';
	set message(msg) {
		this.msgSibling=msg.text;
    }
} 
