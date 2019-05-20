import {Component} from '@angular/core';

@Component({
    selector: 'multi-level-root',
	template: `<h3>Passing Data from Child to Parent Multi-level</h3>
			   <child-one></child-one>`
})

export class MultiLevelParentComponent {}
