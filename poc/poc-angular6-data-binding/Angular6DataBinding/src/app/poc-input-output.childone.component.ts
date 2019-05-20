import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Employee} from './poc-employee';

@Component({
    selector: 'child-one',
    template: `<b>{{addMsg}}</b> (in parent) 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				[e.g., data passing from parent to child]<br/><br/>
				<div>
					First Name:<input (input)="employee.fname=$event.target.value" /> (in child)<br/>
					Last Name:<input (input)="employee.lname=$event.target.value" /> (in child)<br/><br/>
					<button (click)="addEmployee()">Add Employee</button> (in child)
				</div>`
})
export class ChildOneComponent {
    @Input('employeeAddMsg')
	addMsg : string;
	
  	@Output('addEmployeeEvent')
	addEmpEvent = new EventEmitter<Employee>();
	
	employee = new Employee();
	addEmployee() {
		this.addEmpEvent.emit(this.employee);
    }		
}
