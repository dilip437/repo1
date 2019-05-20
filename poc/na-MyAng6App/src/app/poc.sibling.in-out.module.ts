import {NgModule}       from '@angular/core';
import {BrowserModule}  from '@angular/platform-browser';

import {SiblingParentComponent}  from './poc.sibling.in-out.parent.comp';
import {SiblingChildOneComponent}  from './poc.sibling.in-out.child.comp.one';
import {SiblingChildTwoComponent}  from './poc.sibling.in-out.child.comp.two';

@NgModule({
  imports:      [BrowserModule],
  declarations: [SiblingParentComponent, SiblingChildOneComponent, SiblingChildTwoComponent],
  bootstrap:    [SiblingParentComponent]
})

export class SiblingInputOutputModule {}
