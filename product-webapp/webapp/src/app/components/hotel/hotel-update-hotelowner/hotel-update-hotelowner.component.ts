import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-update-hotelowner',
  templateUrl: './hotel-update-hotelowner.component.html',
  styleUrls: ['./hotel-update-hotelowner.component.css']
})
export class HotelUpdateHotelownerComponent {
  getJsonValue: any;
  ownerId = "";
  image: File[] = [];
  email = "";
  name = "";
  mobileNo = "";
  referalCode = "";
  addr = "";
  dob = "";
  hotelList?: Array<Hotel>;
  constructor(private http: HttpClient, private getbyownerIdService: HotelownerService, private updateOwnerService: HotelownerService) { }

  getbyownerid(id: String) {

    this.getbyownerIdService.getbyownerid(id).subscribe((data: any) => {
      this.getJsonValue = data;
      this.ownerId = data.ownerId;
      this.name = data.name;
      this.email = data.email;
      this.mobileNo = data.mobileNo;
      this.referalCode = data.referalCode;
      this.addr = data.addr;
      this.dob = data.dob;
      this.image = data.hotelImage;

    });
  }


  imageUpload(event: any) {
    this.image = event.target.files;
  }
  submitForm() {
    const formData = new FormData();



    formData.append('ownerId', this.ownerId);
    formData.append('name', this.name);
    formData.append('email', this.email);
    formData.append('mobileNo', this.mobileNo);
    formData.append('referalCode', this.referalCode);
    formData.append('addr', this.addr);
    formData.append('dob', this.dob);

    // formData.append('image', this.image);
    for (const image of this.image) {
      formData.append('image', image);
    }

    this.updateOwnerService.updateOwner(formData).subscribe(
      (response: any) => {

        alert('Update Succesfully');
      },
      (error) => {

        alert('ownerId not exist in DataBase ');
      }
    );
  }


}







