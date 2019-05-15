import { Component, OnInit } from '@angular/core';
import { MyserviceService } from './my.service.service';
@Component({
   selector: 'my-service-child-cmp',
   template: `
            <p>{{newcomponent}}</p>
            <p>Today's Date : {{todaydate}}</p>
        `
   /* ,
   styleUrls: ['./new-cmp.component.css'] */
})
export class MyServiceChildComponent implements OnInit {
   todaydate;
   newcomponent = "Entered in new component created";
   constructor(private myservice: MyserviceService) {}
   ngOnInit() {
      this.todaydate = this.myservice.showTodayDate();
   }
}