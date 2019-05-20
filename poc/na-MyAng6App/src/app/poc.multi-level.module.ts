import {NgModule}       from '@angular/core';
import {BrowserModule}  from '@angular/platform-browser';

import {MultiLevelParentComponent}  from './poc.multi-level.parent.comp';
import {MultiLevelChildComponentOne}  from './poc.multi-level.child.comp.level-one';
import {MultiLevelChildComponentTwo}  from './poc.multi-level.child.comp.level-two';

@NgModule({
  imports:      [BrowserModule],
  declarations: [MultiLevelParentComponent, 
                  MultiLevelChildComponentOne, 
                  MultiLevelChildComponentTwo],
  bootstrap:    [MultiLevelParentComponent]
})

export class MultiLevelModule {}
