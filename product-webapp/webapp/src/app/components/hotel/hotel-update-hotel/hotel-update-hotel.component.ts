import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-update-hotel',
  templateUrl: './hotel-update-hotel.component.html',
  styleUrls: ['./hotel-update-hotel.component.css']
})
export class HotelUpdateHotelComponent {
  getJsonValue: any;
  hotelId = "";
  image: File[] = [];
  hotelName = "";
  hotelAddress = "";
  location = "";
  referalCode = "";
  maintanance = "";
  price: any;
  acNonAc = "";
  wifi = "";
  restorent = "";
  nearbyTraspotation = "";
  constructor(private http: HttpClient, private getbyIdService: HotelownerService, private updateHotelService: HotelownerService) { }

  getbyid(id: String) {

    this.getbyIdService.getbyid(id).subscribe((data: any) => {
      this.getJsonValue = data;
      this.hotelId = data.hotelId;
      this.hotelName = data.hotelName;
      this.hotelAddress = data.hotelAddress;
      this.location = data.location;
      this.referalCode = data.referalCode;
      this.maintanance = data.maintanance;
      this.price = data.price;
      this.acNonAc = data.acNonAc;
      this.restorent = data.restorent;
      this.nearbyTraspotation = data.nearbyTraspotation;
      this.wifi = data.wifi;
      this.image = data.hotelImage;
      
    });
  }


  imageUpload(event: any) {
    this.image = event.target.files;
  }
  submitForm() {
    const formData = new FormData();
 


    formData.append('hotelId', this.hotelId);
    formData.append('hotelName', this.hotelName);
    formData.append('hotelAddress', this.hotelAddress);
    formData.append('location', this.location);
    formData.append('referalCode', this.referalCode);
    formData.append('price', this.price);
    formData.append('acNonAc', this.acNonAc);
    formData.append('wifi', this.wifi);
    formData.append('restorent', this.restorent)
    formData.append('nearbyTraspotation', this.nearbyTraspotation)
    formData.append('maintanance', this.maintanance);

    // formData.append('image', this.image);
    for (const image of this.image) {
      formData.append('image', image);
    }

    this.updateHotelService.updatehotel(formData).subscribe(
      (response: any) => {
        
        alert('Hotel Added Succesfully');
      },
      (error) => {
        console.log('error in adding Hotel', error);
        alert('Enter valid details');
      }
    );
  }


}





