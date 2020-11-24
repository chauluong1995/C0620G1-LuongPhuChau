import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {EmployeeService} from "../../../services/employee/employee.service";

@Component({
  selector: 'app-delete-dialog',
  templateUrl: './delete-dialog.component.html',
  styleUrls: ['./delete-dialog.component.css']
})
export class DeleteDialogComponent implements OnInit {
  public employee;
  private idDelete: any;

  constructor(
    public dialogRef: MatDialogRef<DeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private employeeService: EmployeeService
  ) { }

  ngOnInit() {
    this.employee = this.data.dataNeed;
    this.idDelete = this.data.dataNeed.id;
    // console.log(this.data)
  }

  deleteEmployee(id: any) {
    this.employeeService.deleteEmployeeService(this.idDelete).subscribe(data => {
      this.dialogRef.close();
    })
  }
}
