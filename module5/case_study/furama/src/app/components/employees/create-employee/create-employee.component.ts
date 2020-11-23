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
      name: ['',[Validators.required, Validators.minLength(5)]],
      birthDay: ['',[Validators.required]],
      idCard: ['',[Validators.required]],
      salary: ['',[Validators.required]],
      phoneNumber: ['',[Validators.required]],
      email: ['',[Validators.required]],
      address: ['',[Validators.required]],
      position: ['',[Validators.required]],
      educationDegree: ['',[Validators.required]],
      division: ['',[Validators.required]]
    })
  }

  createNewEmployee() {
    this.employeeService.createNewEmployeeService(this.formCreateNewEmployee.value).subscribe(data => {
      this.router.navigateByUrl('employee-list').then(_ => { });
    })
  }
}
