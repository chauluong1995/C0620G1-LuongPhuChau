import {Component, Inject, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators, AbstractControl, ValidationErrors} from '@angular/forms';
import {Router} from "@angular/router";
import {CustomerService} from "../../../services/customer/customer.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Observable, of} from "rxjs";
import {CustomerValidators} from "./validate-id";

export interface CustomerInterface {
  "idFormat": string,
  "name": string,
  "birthDay": string,
  "gender": string,
  "idCard": string,
  "phoneNumber": string,
  "email": string,
  "address": string,
  "type": string,
  "id": number
}

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  public formCreateNewCustomer: FormGroup;
  public customerTypeList = [];
  public customerList: CustomerInterface[] = [];

  constructor(
    private customerService: CustomerService,
    public dialogRef: MatDialogRef<CreateCustomerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public formBuilder: FormBuilder,
    public router: Router
  ) {
  }

  ngOnInit() {
    // this.customerService.getAllCustomers().toPromise().then(data => {
    //   this.customerList = data;
    //   console.log(this.customerList);
    // });
    this.customerService.getAllCustomerType().subscribe(dataType => {
      this.customerTypeList = dataType;
    });
    this.formCreateNewCustomer = this.formBuilder.group({
      idFormat: ['', Validators.compose([Validators.required, Validators.pattern('^(KH-)[0-9]{4}$')]),this.customerService.userValidator,{updateOn: 'submit'}],
      // idFormat: ['', [Validators.required, this.validateIDFormat]],
      name: ['', Validators.required],
      birthDay: ['', [Validators.required, Validators.pattern(
        "^((0[1-9])|([1-2][0-9])|(3[0-1]))[/]((0[1-9])|(1[0-2]))[/]((19[0-9]{2})|(200[0-2]))$")]],
      gender: [''],
      idCard: ['', [Validators.required, Validators.pattern('^(([0-9]{12})|([0-9]{9}))$')]],
      phoneNumber: ['', [Validators.required,
        Validators.pattern('^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$')]],
      email: ['', [Validators.required, Validators.email]],
      // Validators.pattern('^[a-zA-Z0-9]+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$')
      address: [''],
      type: ['']
    });
  }

  createNewCustomer() {
    this.customerService.createNewCustomerService(this.formCreateNewCustomer.value).subscribe(data => {
      // this.router.navigateByUrl('customer-list').then(_ => { });
      this.dialogRef.close();
    })
  }

  // validateIDFormat(control: AbstractControl) {
  //   const regex = RegExp('^(KH-)[0-9]{4}$');
  //   if (!regex.test(control.value)) {
  //     return {ok: true};
  //   }
  //   return null;
  // }

  // validateIDFormat(control: AbstractControl) {
  //   this.customerService.getAllCustomers().toPromise().then(data => {
  //     this.customerList = data;
  //     for (let element of this.customerList) {
  //       if (element.idFormat === control.value) {
  //         return {ok: true};
  //       }
  //     }
  //     return null;
  //   });
  // }

}

