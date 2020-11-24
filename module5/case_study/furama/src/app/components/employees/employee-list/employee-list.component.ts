import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../../services/employee/employee.service";
import {MatDialogModule} from "@angular/material/dialog";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public employeeList;
  term: any;
  p: any;

  constructor(
    public employeeService: EmployeeService
  ) {
  }

  ngOnInit() {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employeeList = data;
    })
  }

  openDialogDelete() {
    console.log('ok');
  }

  resetSearch() {
    this.term = ""
  }
}
