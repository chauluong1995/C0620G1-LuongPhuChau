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

  constructor(
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router
  ) { }

  ngOnInit() {
    this.formCreateNewCustomer = this.formBuilder.group({
      idFormat: [''],
      name: [''],
      birthDay: [''],
      gender: [''],
      idCard: [''],
      phoneNumber: [''],
      email: [''],
      address: [''],
      type: ['']
    })
  }

  createNewCustomer() {
    this.customerService.createNewCustomerService(this.formCreateNewCustomer.value).subscribe(data => {
      this.router.navigateByUrl('customer-list').then(_ => { });
    })
  }
}
