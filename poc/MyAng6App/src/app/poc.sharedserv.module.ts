import {NgModule}       from '@angular/core';
import {BrowserModule}  from '@angular/platform-browser';

import { SiblingSharedService } from './poc.sharedserv.service';
import { SharedServiceParentComponent } from './poc.sharedserv.parent.component';
import { SharedServiceChildComponentOne } from './poc.sharedserv.child.component.one';
import { SharedServiceChildComponentTwo } from './poc.sharedserv.child.component.two';

@NgModule({
    declarations: [
     SharedServiceParentComponent,
     SharedServiceChildComponentOne,
     SharedServiceChildComponentTwo
    ],
    imports: [
       BrowserModule
    ],
    providers: [SiblingSharedService],
    bootstrap: [SharedServiceParentComponent]
 })

export class SharedServiceParentModule {}
