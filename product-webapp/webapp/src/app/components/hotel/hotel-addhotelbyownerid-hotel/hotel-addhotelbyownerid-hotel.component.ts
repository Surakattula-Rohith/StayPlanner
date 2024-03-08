import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-addhotelbyownerid-hotel',
  templateUrl: './hotel-addhotelbyownerid-hotel.component.html',
  styleUrls: ['./hotel-addhotelbyownerid-hotel.component.css']
})
export class HotelAddhotelbyowneridHotelComponent {
  ownerId: any;
  hotelId = "";
  image: File[] = [];
  hotelName = "";
  price: any;
  acNonAc = "";
  wifi = "";
  maintanance = "";
  hotelAddress = "";
  location = "";
  referalCode = "";
  nearbyTraspotation = "";
  restorent = "";
  gstNumber = "";

  constructor(
    private http: HttpClient,
    private addHotelService: HotelownerService
  ) { }

  imageUpload(event: any) {
    this.image = event.target.files;
  }
  getbyid(id: String) {
    this.ownerId = id;
  }
  submitForm() {
    const formData = new FormData();
       formData.append('hotelId', this.hotelId);
    formData.append('hotelName', this.hotelName);
    formData.append('price', this.price);
    formData.append('acNonAc', this.acNonAc);
    formData.append('wifi', this.wifi);
    formData.append('hotelAddress', this.hotelAddress);
    formData.append('location', this.location);
    formData.append('referalCode', this.referalCode);
    formData.append('maintanance', this.maintanance);
    formData.append('nearbyTranspotation', this.nearbyTraspotation);
    formData.append('restorent', this.restorent);
    formData.append('gstNumber', this.gstNumber);

    for (const image of this.image) {
      formData.append('image', image);
    }

    this.addHotelService.addHotel(formData, this.ownerId).subscribe(
      (response: any) => {
        alert('added Succesfully');
      },
      (error) => {
        console.log('error in adding Room', error);
        alert('Please give correct details');
      }
    );
  }
}






