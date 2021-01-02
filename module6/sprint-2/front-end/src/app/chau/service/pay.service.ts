import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PayService {
  protected readonly API: string = 'http://localhost:8080/chau';

  constructor(
    protected http: HttpClient,
    protected router: Router,
  ) {
  }

  /**
   * Chau start
   */
  getListMemberCardByIDCustomer(idFind): Observable<any> {
    return this.http.get(this.API + '/list/' + idFind);
  }

  payByMoMoService(money): void {
    // const signature = HmacSHA256(data, secretkey);
    window.location.href = 'https://test-payment.momo.vn/qr/index.php';
  }

  updateMemberCardAfterPay(money, memberCardList): Observable<any> {
    return this.http.get(this.API + '/pay/' + money + '/' + memberCardList);
  }

  /**
   * Chau end
   */
}
