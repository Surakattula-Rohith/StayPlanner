import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HotelOwner } from '../model/HotelOwner';
import { Admin } from '../model/admin';
import { Booking } from '../model/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

 
  constructor(private http : HttpClient) { }

  addBooking(booking : Booking){
    return this.http.post('http://localhost:8079/api/bookhotel', booking);
  }
  
}
