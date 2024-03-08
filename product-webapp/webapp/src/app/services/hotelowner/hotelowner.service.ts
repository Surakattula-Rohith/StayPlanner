import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HotelOwner } from 'src/app/model/HotelOwner';
import { Admin } from 'src/app/model/admin';

@Injectable({
  providedIn: 'root'
})
export class HotelownerService {
  constructor(private http: HttpClient) { }

  addHotelOwner(hotelOwner: HotelOwner) {
    return this.http.post('http://localhost:8083/api/v1/addhotelowner', hotelOwner);
  }

  viewAllHotelOwners(): Observable<any> {
    return this.http.get('http://localhost:8083/api/v1/viewallhotelowner');
  }

  updateHotelOwner(hotelOwner: HotelOwner): Observable<any> {
    return this.http.put('http://localhost:8083/api/v1/updatehotelowner', hotelOwner);
  }

  private url1 = "http://localhost:8083/viewallreview";
  getAllReviews(): Observable<any> {
    return this.http.get(this.url1)
  }
  private url = "http://localhost:8083/viewallpayment";
  getAllPayments(): Observable<any> {
    return this.http.get(this.url)
  }
  private urlO = "http://localhost:8083/api/v1/viewallhotelowner";
  getAllOwner(): Observable<any> {
    return this.http.get(this.urlO)
  }
  private urlv = "http://localhost:8083/hotel/viewall";
  getAllHotels(): Observable<any> {
    return this.http.get(this.urlv)
  }
  getbyownerid(id: String): Observable<any> {
    const ur1o = `http://localhost:8083/ap1/v1/viewbyownerId/${1}`;
    return this.http.get<void>(ur1o);
  }
  private urlo1 = "http://localhost:8083/api/v1/updatehotelowner";
  updateOwner(owner: FormData): Observable<any> {
    return this.http.put<FormData>(this.urlo1, owner);
  }
  deletebyhotelid(hotelId: String): Observable<any> {
    const ur = `http://localhost:8083/hotel/delete/${hotelId}`;
    return this.http.delete<void>(ur);
  }
  deletebyroomid(roomId: String): Observable<any> {
    const ur = `http://localhost:8083/room/deleteroom/${roomId}`;
    return this.http.delete<void>(ur);
  }
  private urlR = "http://localhost:8083/room/viewallroom";
  getAllRoom(): Observable<any> {
    return this.http.get(this.urlR)
  }
  getbyid(id: String): Observable<any> {
    const ur1 = `http://localhost:8083/hotel/viewbyId/${id}`;
    return this.http.get<void>(ur1);
  }
  private urlu1 = "http://localhost:8083/hotel/update";
  updatehotel(hotel: FormData): Observable<any> {
    return this.http.put<FormData>(this.urlu1, hotel);
  }
  private urlO1 = "http://localhost:8083/api/v1/addhotelowner";
  addOwner(newOwner: FormData): Observable<any> {
    return this.http.post<FormData>(this.urlO1, newOwner);
  }
  addHotel(newHotel: FormData, id: String): Observable<any> {
    const url1 = `http://localhost:8083/api/v1/addhotel/${id}`;
    return this.http.post<FormData>(url1, newHotel);
  }
  addRoom(newRoom: FormData, id: String): Observable<any> {
    const urlr = `http://localhost:8083/hotel/addroom/${id}`;
    return this.http.post<FormData>(urlr, newRoom);
  }



}
