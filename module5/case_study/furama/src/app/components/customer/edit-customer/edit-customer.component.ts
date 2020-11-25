import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {CustomerService} from "../../../services/customer/customer.service";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  public formEditCustomer: FormGroup;
  public customerTypeList;

  constructor(
    public dialogRef: MatDialogRef<EditCustomerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.customerService.getAllCustomerType().subscribe(data => {
      this.customerTypeList = data;
    });
    this.formEditCustomer = this.formBuilder.group({
      idFormat: [this.data.dataNeed.idFormat],
      name: [this.data.dataNeed.name, [Validators.required]],
      birthDay: [this.data.dataNeed.birthDay, [Validators.required]],
      gender: [this.data.dataNeed.gender, [Validators.required]],
      idCard: [this.data.dataNeed.idCard, [Validators.required,
        Validators.pattern('^(([0-9]{12})|([0-9]{9}))$')]],
      phoneNumber: [this.data.dataNeed.phoneNumber, [Validators.required,
        Validators.pattern('^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$')]],
      email: [this.data.dataNeed.email, [Validators.required,
        Validators.pattern('^[a-zA-Z]+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$')]],
      address: [this.data.dataNeed.address, [Validators.required]],
      type: [this.data.dataNeed.type.name, [Validators.required]],
    });
    console.log(this.formEditCustomer.value);
  }

  editCustomer() {
    const idEdit = this.data.dataNeed.id;

    for (let element of this.customerTypeList) {
      // console.log(element.name);
      // console.log(this.formEditCustomer.value.type.name);
      if (element.name === this.formEditCustomer.value.type) {
        this.formEditCustomer.value.type = element;
        break;
      }
    }

    this.customerService.editCustomerService(this.formEditCustomer.value, idEdit).subscribe(data => {
      // this.router.navigateByUrl('employee-list').then(_ => {
      // });
      this.dialogRef.close();
    })
  }
}
