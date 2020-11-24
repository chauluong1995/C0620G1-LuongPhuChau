import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {CustomerService} from "../../../services/customer/customer.service";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  public formCreateNewCustomer: FormGroup;
  public customerTypeList;

  constructor(
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router
  ) { }

  ngOnInit() {
    this.formCreateNewCustomer = this.formBuilder.group({
      idFormat: ['',[Validators.required, Validators.pattern('^(KH-)[0-9]{4}$')]],
      name: ['', Validators.required],
      birthDay: ['',[Validators.required, Validators.pattern(
        "^((0[1-9])|([1-2][0-9])|(3[0-1]))[/]((0[1-9])|(1[0-2]))[/]((19[0-9]{2})|(200[0-2]))$")]],
      gender: [''],
      idCard: ['',[Validators.required, Validators.pattern('^(([0-9]{12})|([0-9]{9}))$')]],
      phoneNumber: ['',[Validators.required,
        Validators.pattern('^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$')]],
      email: ['',[Validators.required, Validators.email]],
      // Validators.pattern('^[a-zA-Z]+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$')
      address: [''],
      type: ['']
    });
    this.customerService.getAllCustomerType().subscribe(dataType => {
      this.customerTypeList = dataType;
    })
  }

  createNewCustomer() {
    this.customerService.createNewCustomerService(this.formCreateNewCustomer.value).subscribe(data => {
      this.router.navigateByUrl('customer-list').then(_ => { });
    })
  }
}
