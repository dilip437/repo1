import {Component} from '@angular/core';

@Component({
    selector: 'input-output',
	template: `
				<h3>Passing data from Parent to Child using @Input and @output<br/>
				Passing Data from Child to Parent @Input and @output</h3>
				<child-one
					[employeeAddMsg]="empAddMsg" 						
				    (addEmployeeEvent) = "saveData($event)" >
				</child-one>
				<p>Name: <b>{{empFullName}}</b> (in parent)
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				[e.g., data passing from child to parent]
				</p> `
})

export class ParentComponent {
	empAddMsg = 'Add Employee';
	empFullName = '';
	saveData(emp) {
		this.empFullName = emp.fname + ' ' + emp.lname ;
    }
} 
