import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-add-owner',
  templateUrl: './hotel-add-owner.component.html',
  styleUrls: ['./hotel-add-owner.component.css']
})
export class HotelAddOwnerComponent {
  ownerId = "";
  image: File[] = [];
  email = "";
  name = "";
  mobileNo = "";
  referalCode = "";
  addr = "";
  dob = "";
  hotelList?: Array<Hotel>;

  constructor(
    private http: HttpClient,
    private addOwnerService: HotelownerService
  ) { }
 

  imageUpload(event: any) {
    this.image = event.target.files;
  }
  submitForm() {
    const formData = new FormData();
 


    formData.append('ownerId', this.ownerId);
    formData.append('email', this.email);
    formData.append('name', this.name);
    formData.append('mobileNo', this.mobileNo);
    formData.append('addr', this.addr);
    formData.append('dob', this.dob);

    formData.append('maintanance', this.referalCode);

    for (const image of this.image) {
      formData.append('image', image);
    }

    this.addOwnerService.addOwner(formData).subscribe(
      (response: any) => {
        alert('Owner Added Succesfully');
      },
      (error) => {
        
        alert('Add valid details');
      }
    );
  }

}






