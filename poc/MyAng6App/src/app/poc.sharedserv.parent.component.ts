import {Component} from '@angular/core';

@Component({
    selector: 'sibling-shared-service-root',
    template: `
                <h3>Passing data between Sibling component  using Shared Service</h3>
                <sibling-child-cmp-one></sibling-child-cmp-one>
                <sibling-child-cmp-two></sibling-child-cmp-two>
			  `
})

export class SharedServiceParentComponent {}
