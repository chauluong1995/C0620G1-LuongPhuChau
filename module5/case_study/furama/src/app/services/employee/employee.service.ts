import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  // public API: string = 'http://localhost:8080/employeeListRest';
  // public APICreate: string = 'http://localhost:8080/employeeListRest/create';
  public API: string = 'http://localhost:3000/employees';
  public APIPosition: string = 'http://localhost:3000/position';
  public APIDivision: string = 'http://localhost:3000/division';
  public APIEducationDegree: string = 'http://localhost:3000/educationdegree';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllPosition(): Observable<any> {
    return this.http.get(this.APIPosition);
  }

  getAllDivision(): Observable<any> {
    return this.http.get(this.APIDivision);
  }

  getAllEducationDegree(): Observable<any> {
    return this.http.get(this.APIEducationDegree);
  }

  getAllEmployees(): Observable<any> {
    return this.http.get(this.API);
  }

  createNewEmployeeService(employee): Observable<any> {
    return this.http.post(this.API, employee)
  }

  findByID(idNeedFind: any): Observable<any> {
    return this.http.get(this.API + '/' + idNeedFind)
  }

  deleteEmployeeService(idNeedDelete: any): Observable<any> {
    return this.http.delete(this.API + '/' + idNeedDelete)
  }

  editEmployeeService(employee, idNeedEdit): Observable<any> {
    return this.http.put(this.API + '/' + idNeedEdit, employee)
  }
}
