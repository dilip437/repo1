import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { RouterModule} from '@angular/router';

import { MyserviceService } from './my.service.service';
import { MyServiceParentComponent } from './my.service.parent.component';
import { MyServiceChildComponent } from './my.service.child.component';

@NgModule({
   declarations: [
      MyServiceParentComponent,
      MyServiceChildComponent
   ],
   imports: [
      BrowserModule
   ],
   providers: [MyserviceService],
   bootstrap: [MyServiceParentComponent]
})
export class MyServiceAppModule { }