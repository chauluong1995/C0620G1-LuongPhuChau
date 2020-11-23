import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public API: string = 'http://localhost:8080/employeeListRest';
  public APICreate: string = 'http://localhost:8080/employeeListRest/create';

  constructor(
    public http: HttpClient
  ) { }

  getAllEmployees(): Observable<any> {
    return this.http.get(this.API);
  }

  createNewEmployeeService(employee): Observable<any> {
    return this.http.post(this.APICreate, employee)
  }
}
