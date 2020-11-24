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
      name: ['',[Validators.required]],
      birthDay: ['',[Validators.required, Validators.pattern(
        "^((0[1-9])|([1-2][0-9])|(3[0-1]))[/]((0[1-9])|(1[0-2]))[/]((19[0-9]{2})|(200[0-2]))$")]],
      idCard: ['',[Validators.required, Validators.pattern('^(([0-9]{12})|([0-9]{9}))$')]],
      salary: ['',[Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$')]],
      phoneNumber: ['',[Validators.required,
        Validators.pattern('^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$')]],
      email: ['',[Validators.required, Validators.pattern('^[a-zA-Z]+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$')]],
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
