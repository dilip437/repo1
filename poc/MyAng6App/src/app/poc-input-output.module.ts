import {NgModule}       from '@angular/core';
import {BrowserModule}  from '@angular/platform-browser';

import {ParentComponent}  from './poc-input-output.parent.component';
import {ChildOneComponent}  from './poc-input-output.childone.component';

@NgModule({
  imports:      [BrowserModule],
  declarations: [ParentComponent, ChildOneComponent],
  bootstrap:    [ParentComponent]
})

export class PocInputOutputModule {}
