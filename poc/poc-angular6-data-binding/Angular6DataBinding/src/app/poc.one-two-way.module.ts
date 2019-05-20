import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { PocDataBindComponent }  from './poc.one-two-way.component';

@NgModule({
    imports:      [ BrowserModule, FormsModule ],
    declarations: [ PocDataBindComponent ],
    providers: [],
    bootstrap:    [ PocDataBindComponent ]
  })
  export class PocDataBindModule {}
  