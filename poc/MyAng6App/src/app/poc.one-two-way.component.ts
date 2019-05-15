import { Component } from '@angular/core';

@Component ({
   selector: 'my-app',
   template: `<h3>Single Component Two way binding via NgModel</h3>
              Value 1 : <input type="text" [(ngModel)]="name1" />
              <br/>
              Value 2 : <input type="text" [(ngModel)]="name1" />
              <h3>Single Component One way via events</h3>
              Value 3 : <input [value]="name2" (input)="name2=$event.target.value" />
              <br/>
              Value 4 : <input [value]="name2" />`
})

export class PocDataBindComponent  { 
    name1='';
    name2='';
    constructor(){}
}

