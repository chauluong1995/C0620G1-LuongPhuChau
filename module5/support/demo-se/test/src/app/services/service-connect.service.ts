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
  public readonly API: string = 'http://localhost:3000/products';
  public readonly APIProductType: string = 'http://localhost:3000/productType';
  public readonly APIStatus: string = 'http://localhost:3000/status';

  constructor(
    public http: HttpClient
  ) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API);
  }

  getAllType(): Observable<any> {
    return this.http.get(this.APIProductType);
  }

  getAllStatus(): Observable<any> {
    return this.http.get(this.APIStatus);
  }

  createNewService(variable): Observable<any> {
    return this.http.post(this.API, variable)
  }

  deleteService(idNeedDelete: any): Observable<any> {
    return this.http.delete(this.API + '/' + idNeedDelete)
  }

  editService(customer, idNeedEdit): Observable<any> {
    return this.http.put(this.API + '/' + idNeedEdit, customer)
  }

  validateID(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<{ [key: string]: any } | null> => {
      return this.search(control.value)
        .pipe(
          map(res => {
            if (res.length) {
              return {'idExists': true};
            }
          })
        );
    };
  }

  search(text) {
    return timer(50)
      .pipe(
        switchMap(() => {
          return this.http.get<any>(`${URL}?idFormat=${text}`)
        })
      );
  }

  findByID(idNeedFind: any): Observable<any> {
    return this.http.get(this.API + '/' + idNeedFind)
  }

  findByFloor(key: string): Observable<any> {
    return this.http.get(`${URL}?floors=${key}`)
  }

  findByPrice(key: string): Observable<any> {
    return this.http.get(`${URL}?rentPrice_like=${key}`)
  }

  findByArea(key: string): Observable<any> {
    return this.http.get(`${URL}?area_like=${key}`)
  }

  findByFloorAndPriceAndArea(floor: string, price: string, area: string): Observable<any> {
    return this.http.get(`${URL}?floors_like=${floor}&rentPrice_like=${price}&area_like=${area}`)
  }
}
