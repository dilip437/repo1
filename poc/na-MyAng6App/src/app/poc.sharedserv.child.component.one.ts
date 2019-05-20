import { Component } from '@angular/core';
import { SiblingSharedService } from './poc.sharedserv.service';

@Component({
   selector: 'sibling-child-cmp-one',
   template: `<p>Child One</p>
              <input [value]="message" (input)="message=$event.target.value" />`
})

export class SharedServiceChildComponentOne {
   constructor(private myservice: SiblingSharedService) {}
   set message(msg) {
       this.myservice.message=msg;
   }
   get message() {
    return this.myservice.message;
   }
}
