import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-get-payment',
  templateUrl: './hotel-get-payment.component.html',
  styleUrls: ['./hotel-get-payment.component.css']
})
export class HotelGetPaymentComponent {
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(private http: HttpClient, private getAllPayment: HotelownerService) { }
  ngOnInit(): void {
    this.
      getAllDetails()
  }

  getAllDetails() {
    this.getAllPayment.getAllPayments().subscribe((data: any) => {
      this.getJsonValue = data;
      
    });
  }

}
