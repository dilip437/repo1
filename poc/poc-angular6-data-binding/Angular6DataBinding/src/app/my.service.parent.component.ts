import { Component } from '@angular/core';
import { MyserviceService } from './my.service.service';

@Component({
   selector: 'my-service-root',
   template: `
                {{todaydate}}
                <my-service-child-cmp></my-service-child-cmp>
            `
})
export class MyServiceParentComponent {
   title = 'Angular 6 Project!';
   todaydate;
   constructor(private myservice: MyserviceService) {}
   ngOnInit() {
      this.todaydate = this.myservice.showTodayDate();
   }
}
