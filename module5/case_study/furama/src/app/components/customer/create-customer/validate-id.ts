import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, timer} from "rxjs";
import {map, switchMap} from "rxjs/operators";
import {AbstractControl, AsyncValidatorFn} from "@angular/forms";



@Injectable({
  providedIn: 'root'
})
export class CustomerValidators {
  constructor(private http: HttpClient) {}



}
