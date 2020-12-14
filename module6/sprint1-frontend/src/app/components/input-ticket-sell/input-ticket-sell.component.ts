import {Component, OnInit} from '@angular/core';
import {TicketService} from '../../service/ticket/ticket.service';

@Component({
  selector: 'app-input-ticket-sell',
  templateUrl: './input-ticket-sell.component.html',
  styleUrls: ['./input-ticket-sell.component.css']
})
export class InputTicketSellComponent implements OnInit {
  protected flightInformationDeparture = [];
  protected flightInformationArrival = [];
  protected idFlightDeparture = 1;
  protected idFlightArrival = 2;

  constructor(
    public ticketService: TicketService,
  ) {
  }

  ngOnInit() {
    this.ticketService.findFlightInformationByIDService(this.idFlightDeparture).subscribe(
      (data) => {
        this.flightInformationDeparture = data;
      },
      () => {
      },
      () => {
        this.ticketService.findFlightInformationByIDService(this.idFlightArrival).subscribe(data => {
          this.flightInformationArrival = data;
        });
      }
    );
  }

}
