import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {EmployeeService} from "../../../services/employee/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  public formEditEmployee: FormGroup;
  public positionList;
  public divisionList;
  public educationDegreeList;

  constructor(
    public dialogRef: MatDialogRef<EditEmployeeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public formBuilder: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.formEditEmployee = this.formBuilder.group({
      name: [this.data.dataNeed.name, [Validators.required]],
      birthDay: [this.data.dataNeed.birthDay, [Validators.required, Validators.pattern(
        "^((0[1-9])|([1-2][0-9])|(3[0-1]))[/]((0[1-9])|(1[0-2]))[/]((19[0-9]{2})|(200[0-2]))$")]],
      idCard: [this.data.dataNeed.idCard, [Validators.required,
        Validators.pattern('^(([0-9]{12})|([0-9]{9}))$')]],
      salary: [this.data.dataNeed.salary, [Validators.required, Validators.pattern('^([0-9]+([.][0-9]+)?)$')]],
      phoneNumber: [this.data.dataNeed.phoneNumber, [Validators.required,
        Validators.pattern('^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$')]],
      email: [this.data.dataNeed.email, [Validators.required,
        Validators.pattern('^[a-zA-Z]+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$')]],
      address: [this.data.dataNeed.address, [Validators.required]],
      position: [this.data.dataNeed.position, [Validators.required]],
      educationDegree: [this.data.dataNeed.educationDegree, [Validators.required]],
      division: [this.data.dataNeed.division, [Validators.required]]
    });
    this.employeeService.getAllPosition().subscribe(data => {
      this.positionList = data;
    });
    this.employeeService.getAllDivision().subscribe(data => {
      this.divisionList = data;
    });
    this.employeeService.getAllEducationDegree().subscribe(data => {
      this.educationDegreeList = data;
    })
  }

  editEmployee() {
    const idEdit = this.data.dataNeed.id;
    this.employeeService.editEmployeeService(this.formEditEmployee.value, idEdit).subscribe(data => {
      // this.router.navigateByUrl('employee-list').then(_ => {
      // });
      this.dialogRef.close();
    })
  }
}
