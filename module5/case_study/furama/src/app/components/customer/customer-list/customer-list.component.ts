import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../../services/customer/customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customerList;

  constructor(
    public customerService: CustomerService
  ) { }

  ngOnInit() {
    this.customerService.getAllCustomers().subscribe(data => {
      this.customerList = data;
    })
  }
}
