import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, UrlSegment } from '@angular/router';
import { Observable } from 'rxjs';
import { Hotel } from 'src/app/model/Hotel';
import { Booking } from 'src/app/model/booking';
import { Customer } from 'src/app/model/customer';
import { AuthService } from 'src/app/services/auth.service';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {

  payment: any;
  reviewDesc: string = "";
  secretId: string = "";
  secretKey: string = "";
  razorpayOrderId: string = "";
  applicationFee: string = "";

  psName: string = "";
  email: string = "";




  ngOnInit(): void {
    let response = this.http.get("http://localhost:9095/email/payment/data");


    response.subscribe((data) => {

      if (Array.isArray(data) && data.length > 0) {
        this.payment = data[data.length - 1];

      }
    });
  }


  booking: Booking;
  hotel1: Hotel;
  customer1: Customer;
  hId: string = "";



  errorMsg: string = "Error occured while submission.";

  constructor(private http: HttpClient, private bookingService: BookingService) {

    this.booking = new Booking();
    this.customer1 = new Customer();
    this.hotel1 = new Hotel();
  }



  getHotel(hId: string): Observable<any> {

    return this.http.get('http://localhost:8083/hotel/viewbyId/' + hId);
  }



  getCustomer(cId: number): Observable<any> {

    return this.http.get('http://localhost:8090/customers/getcustomer/' + cId);
  }
  addBooking() {

    let str = this.booking.hotId;
    let tempHotel = this.getHotel(str).subscribe((response) => {
      this.hotel1 = response;



    });
    let str2 = this.booking.cusId;
    let tempCust = this.getCustomer(str2).subscribe((response) => {
      this.customer1 = response;

    });

    this.booking.customer = this.customer1;
    this.booking.hotel = this.hotel1


    this.bookingService.addBooking(this.booking).subscribe(resp => {

      alert("Data Saved");
      this.booking = new Booking;
    }, error => {
      console.log(this.errorMsg)
    });
  }

  popupVisible = false;

  openPopup() {
    this.popupVisible = true;
  }

  closePopup() {
    this.register();
    this.popupVisible = false;
  }

  handleButtonClick() {
    this.addBooking();
    this.openPopup();

  }

  register() {
    let bodyData = {

      "secretId": this.payment.secretId,
      "secretKey": this.payment.secretKey,
      "razorpayOrderId": this.payment.razorpayOrderId,
      "applicationFee": this.payment.applicationFee,
      "psName": this.payment.psName,
      "email": this.payment.email,
      "msgBody": "",
      "subject": ""
    };

    this.http.post("http://localhost:9095/email/sendMail", bodyData, { responseType: 'text' }).subscribe(
      (resultData: any) => {

        alert("Notification Send.");
      });
    this.secretId = '';
    this.secretKey = '';
    this.razorpayOrderId = '';
    this.psName = '';
    this.email = '';
  }


}