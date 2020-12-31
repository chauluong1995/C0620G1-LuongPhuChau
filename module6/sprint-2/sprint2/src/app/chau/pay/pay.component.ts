import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {MemberCardService} from '../service/member-card.service';

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
  public totalMoney = 0;
  public isChecked: boolean;

  constructor(
    private memberCardService: MemberCardService,
  ) {
  }

  ngOnInit(): void {
    this.displayPayPalButton();
    this.getListMemberCard();
  }

  getListMemberCard() {
    this.memberCardService.getListMemberCardByIDCustomer(2).subscribe(
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
          height: 45
        },

        createOrder: (data, actions) => {
          if (this.totalMoney === 0 || this.totalMoney === 2) {
            alert('Vui lòng chọn vé trước khi thanh toán! Xin cảm ơn!');
          } else {
            return actions.order.create({
              purchase_units: [
                {
                  amount: {
                    value: this.totalMoney,
                    currency_code: 'USD'
                  }
                }
              ]
            });
          }
        },

        onCancel(data) {
          alert('Yêu cầu hủy thanh toán thành công!');
          this.getListMemberCard();
          this.memberCardListPay.splice(0, this.memberCardListPay.length);
        },

        onApprove: (data, actions) => {
          return actions.order.capture().then(details => {
            alert('Thanh toán thành công! Cảm ơn quý khách!');
            this.getListMemberCard();
            this.memberCardListPay.splice(0, this.memberCardListPay.length);
          });
        },

        onError: (data, actions) => {
          // alert('Lỗi hệ thống. Quý khách vui lòng liên hệ nhân viên để khắc phục. Mong quý khách thông cảm! Xin cảm ơn!');
          this.getListMemberCard();
          this.memberCardListPay.splice(0, this.memberCardListPay.length);
        }
      }
    ).render(this.paypalRef.nativeElement);
  }

  onCheckboxChange($event: Event, memberCard) {
    // @ts-ignore
    this.isChecked = $event.target.checked;
    if (this.isChecked) {
      this.totalMoney = Math.ceil(this.totalMoney + memberCard.price / 23000);
      console.log(this.totalMoney);
      this.memberCardListPay.push(memberCard.id);
      console.log(this.memberCardListPay);
    } else {
      this.totalMoney = Math.ceil(this.totalMoney - memberCard.price / 23000);
      console.log(this.totalMoney);
      for (let i = 0; i < this.memberCardListPay.length; i++) {
        if (this.memberCardListPay[i] === memberCard.id) {
          this.memberCardListPay.splice(i, i + 1);
        }
      }
      console.log(this.memberCardListPay);
    }
  }
}
