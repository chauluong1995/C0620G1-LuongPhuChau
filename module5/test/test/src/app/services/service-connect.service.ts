import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, timer} from "rxjs";
import {map, switchMap} from "rxjs/operators";
import {AbstractControl, AsyncValidatorFn} from "@angular/forms";

const URL = 'http://localhost:3000/products';

@Injectable({
  providedIn: 'root'
})
export class ServiceConnectService {
  public readonly API: string = 'http://localhost:3000/cars';
  public readonly APIStartPlace: string = 'http://localhost:3000/startPlace';
  public readonly APIEndPlace: string = 'http://localhost:3000/endPlace';

  constructor(
    public http: HttpClient
  ) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API);
  }

  getAllStartPlace(): Observable<any> {
    return this.http.get(this.APIStartPlace);
  }

  getAllEndPlace(): Observable<any> {
    return this.http.get(this.APIEndPlace);
  }

  deleteService(idNeedDelete: any): Observable<any> {
    return this.http.delete(this.API + '/' + idNeedDelete)
  }

  editService(car, idNeedEdit): Observable<any> {
    return this.http.put(this.API + '/' + idNeedEdit, car)
  }

  findByID(idNeedFind: any): Observable<any> {
    return this.http.get(this.API + '/' + idNeedFind)
  }
}
