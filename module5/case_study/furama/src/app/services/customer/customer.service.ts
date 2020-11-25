import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of, timer} from "rxjs";
import {map, switchMap} from "rxjs/operators";
import {AbstractControl, AsyncValidatorFn} from "@angular/forms";

const URL = 'http://localhost:3000/customers';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API: string = 'http://localhost:3000/customers';
  public APICustomerType: string = 'http://localhost:3000/customerType';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllCustomers(): Observable<any> {
    return this.http.get(this.API);
  }

  getAllCustomerType(): Observable<any> {
    return this.http.get(this.APICustomerType);
  }

  createNewCustomerService(customer): Observable<any> {
    return this.http.post(this.API, customer)
  }
  searchCus(text) {
    // debounce
    return timer(1000)
      .pipe(
        switchMap(() => {
          // Check if username is available
          return this.http.get<any>(`${URL}?idFormat=${text}`)
        })
      );
  }

  userValidator(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<{ [key: string]: any } | null> => {
      return this.searchCus(control.value)
        .pipe(
          map(res => {
            // if username is already taken
            console.log(res);
            if (res.length) {
              // return error
              return { 'idExists': true};
            }
          })
        );
    };

  }
}
