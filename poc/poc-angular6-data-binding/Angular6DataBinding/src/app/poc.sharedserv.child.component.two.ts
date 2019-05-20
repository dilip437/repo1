import { Component } from '@angular/core';
import { SiblingSharedService } from './poc.sharedserv.service';

@Component({
    selector: 'sibling-child-cmp-two',
    template: `<p>Child Two</p>
               <input [value]="message" (input)="message=$event.target.value" />`
})

export class SharedServiceChildComponentTwo {
   constructor(private myservice: SiblingSharedService) {}
   set message(msg) {
       this.myservice.message=msg;
   }
   get message() {
    return this.myservice.message;
   }
}