import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemberCardService {
  protected readonly API: string = 'http://localhost:8080/chau/pay';

  constructor(
    protected http: HttpClient
  ) { }

  /**
   * Chau start
   */
  getListMemberCardByIDCustomer(idFind): Observable<any> {
    return this.http.get(this.API + '/list/' + idFind);
  }
  /**
   * Chau end
   */
}
