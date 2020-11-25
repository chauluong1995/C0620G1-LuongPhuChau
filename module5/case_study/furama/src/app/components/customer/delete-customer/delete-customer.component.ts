import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CustomerService} from "../../../services/customer/customer.service";

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {
  public customer;
  private idDelete: any;

  constructor(
    public dialogRef: MatDialogRef<DeleteCustomerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private customerService: CustomerService
  ) { }

  ngOnInit() {
    this.customer = this.data.dataNeed;
    this.idDelete = this.data.dataNeed.id;
    // console.log(this.data)
  }

  deleteCustomer() {
    this.customerService.deleteCustomerService(this.idDelete).subscribe(data => {
      this.dialogRef.close();
    })
  }
}
