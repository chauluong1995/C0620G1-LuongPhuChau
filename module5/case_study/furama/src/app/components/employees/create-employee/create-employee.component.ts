import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {EmployeeService} from "../../../services/employee/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  public formCreateNewEmployee: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.formCreateNewEmployee = this.formBuilder.group({
      name: [''],
      birthDay: [''],
      idCard: [''],
      salary: [''],
      phoneNumber: [''],
      email: [''],
      address: [''],
      position: [''],
      educationDegree: [''],
      division: ['']
    })
  }

  createNewEmployee() {
    this.employeeService.createNewEmployeeService(this.formCreateNewEmployee.value).subscribe(data => {
      this.router.navigateByUrl('employee-list').then(_ => { });
    })
  }
}
