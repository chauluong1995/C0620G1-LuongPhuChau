import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../../services/employee/employee.service";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public employeeList;

  constructor(
    public employeeService: EmployeeService
  ) { }

  ngOnInit() {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employeeList = data;
    })
  }
}
