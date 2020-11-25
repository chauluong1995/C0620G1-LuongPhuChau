import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../../services/employee/employee.service";
import {DeleteDialogComponent} from "../delete-dialog/delete-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {CreateCustomerComponent} from "../../customer/create-customer/create-customer.component";
import {CreateEmployeeComponent} from "../create-employee/create-employee.component";
import {EditEmployeeComponent} from "../edit-employee/edit-employee.component";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public employeeList;
  term: any;
  p: any;
  private employeeCreate;

  constructor(
    public employeeService: EmployeeService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit() {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employeeList = data;
    })
  }

  resetSearch() {
    this.term = ""
  }

  openDialogDelete(id: any): void {
    this.employeeService.findByID(id).subscribe(employee => {
      // console.log(employee);
      const dialogRef = this.dialog.open(DeleteDialogComponent, {
        width: '750px',
        data: {dataNeed: employee},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }

  createNewDialog() {
    const dialogRefCreate = this.dialog.open(CreateEmployeeComponent, {
      width: '950px',
      height: '1500px',
      data: {dataNeed: this.employeeCreate},
      disableClose: true
    });

    dialogRefCreate.afterClosed().subscribe(result => {
      this.ngOnInit()
    })
  }

  openDialogEdit(id: any): void {
    this.employeeService.findByID(id).subscribe(employee => {
      // console.log(employee);
      const dialogRefEdit = this.dialog.open(EditEmployeeComponent, {
        width: '950px',
        height: '1500px',
        data: {dataNeed: employee},
        disableClose: true
      });

      dialogRefEdit.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }
}
