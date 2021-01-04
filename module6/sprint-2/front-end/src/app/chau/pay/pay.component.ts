import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {PayService} from '../service/pay.service';
import {MatDialog} from '@angular/material/dialog';
import {SuccessfullyPayComponent} from '../successfully-pay/successfully-pay.component';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {
  public message = 'nothing';
  public memberCardList = [];
  public memberCardListPay = [];
  @ViewChild('paypalRef', {static: true}) private paypalRef: ElementRef;
  public checked = [];
  public totalMoneyPayPal = 0;
  public totalMoneyMoMo = 0;
  public isChecked: boolean;
  public signature;

  constructor(
    private payService: PayService,
    private dialog: MatDialog,
    protected http: HttpClient,
  ) {
  }

  ngOnInit(): void {
    this.displayPayPalButton();
    this.getListMemberCard();
  }

  getListMemberCard() {
    this.payService.getListMemberCardByIDCustomer(2).subscribe(
      (data) => {
        this.memberCardList = data;
      },
      () => {
        this.message = 'error';
      },
      () => {
      });
  }

  displayPayPalButton() {
    paypal.Buttons(
      {
        style: {
          shape: 'rect',
          color: 'gold',
          layout: 'horizontal',
          label: 'paypal',
          height: 45,
        },

        createOrder: (data, actions) => {
          return actions.order.create({
            purchase_units: [
              {
                amount: {
                  value: this.totalMoneyPayPal,
                  currency_code: 'USD'
                }
              }
            ]
          });
        },

        onCancel(data) {
          alert('Yêu cầu hủy thanh toán thành công!');
          console.log('Đã hủy.');
        },

        onApprove: (data, actions) => {
          return actions.order.capture().then(details => {
            alert('Thông tin đang cập nhật. Vui lòng đợi trong giây lát!');
            this.updateMemberCard();
          });
        },

        onError: (data, actions) => {
          this.refresh();
          alert('Lỗi hệ thống. Quý khách vui lòng liên hệ nhân viên để khắc phục. Mong quý khách thông cảm! Xin cảm ơn!');
          console.log('Lỗi hệ thống.');
        }
      }
    ).render(this.paypalRef.nativeElement);
  }

  onCheckboxChange($event: Event, memberCard) {
    // @ts-ignore
    this.isChecked = $event.target.checked;
    if (this.isChecked) {
      this.totalMoneyPayPal = Math.ceil(this.totalMoneyPayPal + memberCard.price / 23000);
      this.totalMoneyMoMo = this.totalMoneyMoMo + memberCard.price;
      this.memberCardListPay.push(memberCard.id);
    } else {
      this.totalMoneyPayPal = Math.ceil(this.totalMoneyPayPal - memberCard.price / 23000 - 1);
      this.totalMoneyMoMo = this.totalMoneyMoMo - memberCard.price;
      for (let i = 0; i < this.memberCardListPay.length; i++) {
        if (this.memberCardListPay[i] === memberCard.id) {
          this.memberCardListPay.splice(i, i + 1);
        }
      }
    }
  }

  payNothing() {
    alert('Vui lòng chọn vé trước khi thanh toán!');
  }

  refresh() {
    this.memberCardListPay.splice(0, this.memberCardListPay.length);
    this.totalMoneyPayPal = 0;
    this.totalMoneyMoMo = 0;
    this.getListMemberCard();
  }

  updateMemberCard() {
    this.payService.updateMemberCardAfterPay(this.totalMoneyMoMo, this.memberCardListPay)
      .subscribe(
        (data) => {
        },
        () => {
          this.openSuccessfullyPay('failed');
        },
        () => {
          this.openSuccessfullyPay('complete');
        });
  }

  openSuccessfullyPay(message): void {
    const dialogRef = this.dialog.open(SuccessfullyPayComponent, {
      width: '500px',
      data: {notification: message},
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(result => {
      this.refresh();
    });
  }

  payByMoMo() {
    const requestID = Math.ceil(Math.random() * 10000000000);
    this.payService.payByMoMoService(this.totalMoneyMoMo, requestID)
      .subscribe(
        (data) => {
          this.signature = data.message;
        },
        (data) => {
        },
        () => {
          // this.http.post<any>('https://test-payment.momo.vn/gw_payment/payment/qr?partnerCode=MOMOBKUN20180529' +
          //   '&accessKey=klm05TvNBzhg7h7j&requestId=' + requestID +
          //   '&amount=' + this.totalMoneyMoMo + '&orderId=' + requestID +
          //   '&signature=' + this.signature + '&requestType=captureMoMoWallet/post',
          //   {
          //     'accessKey': 'klm05TvNBzhg7h7j',
          //     'partnerCode': 'MOMOBKUN20180529',
          //     'requestType': 'captureMoMoWallet',
          //     'notifyUrl': 'https://momo.vn',
          //     'returnUrl': 'https://momo.vn',
          //     'orderId': requestID,
          //     'amount': this.totalMoneyMoMo,
          //     'orderInfo': 'SDK team.',
          //     'requestId': requestID,
          //     'extraData': 'email=abc@gmail.com',
          //     'signature': this.signature
          //   })
          //   .subscribe(data => {
          //     console.log(data);
          //   });dd
          alert('Sign: ' + this.signature + '\nSign : ' + '1169c7217e88697565077a9007a7a326de9fd956ee03b27b44f080dffa2591cd');
          window.location.href = 'https://test-payment.momo.vn/gw_payment/payment/qr?' +
            'partnerCode=MOMOBKUN20180529' +
            '&accessKey=klm05TvNBzhg7h7j' +
            '&requestId=1609727781' +
            '&amount=7000000' +
            '&orderId=1609727781' +
            '&signature=' + 'baa58d47b16f65b29f89f03de00791db335b96bb6e01f434f74fd75691024d1a' +
            '&requestType=captureMoMoWallet';
        });
  }
}
