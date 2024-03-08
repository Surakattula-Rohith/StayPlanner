import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-addroombyhotelid-hotel',
  templateUrl: './hotel-addroombyhotelid-hotel.component.html',
  styleUrls: ['./hotel-addroombyhotelid-hotel.component.css']
})
export class HotelAddroombyhotelidHotelComponent {
  hotelId: any;
  roomId = "";
  image: File[] = [];
  bedType = "";
  price: any;
  acNonAc = "";
  wifi = "";
  maintanance = "";

  constructor(
    private http: HttpClient,
    private addRoomService: HotelownerService
  ) { }
 

  imageUpload(event: any) {
    this.image = event.target.files;
  }
  getbyid(id: String) {
    this.hotelId = id;
  }
  submitForm() {
    const formData = new FormData();
 


    formData.append('roomId', this.roomId);
    formData.append('bedType', this.bedType);
    formData.append('price', this.price);
    formData.append('acNonAc', this.acNonAc);
    formData.append('wifi', this.wifi);
    formData.append('maintanance', this.maintanance);

    for (const image of this.image) {
      formData.append('image', image);
    }

    this.addRoomService.addRoom(formData, this.hotelId).subscribe(
      (response: any) => {
       
        alert('Room added Succesfully');
      },
      (error) => {
        console.log('error in adding Room', error);
        alert('Enter valid details.');
      }
    );
  }
}





