import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  Validators,
} from '@angular/forms';

import { BreakpointObserver } from '@angular/cdk/layout';
import { StepperOrientation } from '@angular/cdk/stepper';
import { Observable, map } from 'rxjs';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { HotelOwner } from 'src/app/model/HotelOwner';
import { Hotel } from 'src/app/model/Hotel';
import { Room } from 'src/app/model/Room';

@Component({
  selector: 'app-hotel-add-hotelowner',
  templateUrl: './hotel-add-hotelowner.component.html',
  styleUrls: ['./hotel-add-hotelowner.component.css'],
})
export class HotelAddHotelownerComponent {
  ngOnInit(): void {}

 

  hotelOwner: HotelOwner;
  hotel: Hotel;
  room: Room;

  errorMsg: string = 'Error occured while submission.';

  constructor(
    
    private hotelownerService: HotelownerService
  ) {
    this.hotelOwner = new HotelOwner();
    this.hotel = new Hotel();
    this.room = new Room();
  }

  saveData() {
    
    this.hotel.roomList = Array(this.room);
    this.hotelOwner.hotelList = Array(this.hotel);

    this.hotelownerService.addHotelOwner(this.hotelOwner).subscribe(
      (resp) => {
       
            this.hotelOwner = new HotelOwner();
        this.hotel = new Hotel();
        this.room = new Room();
      },
      (error) => {
        console.log(this.errorMsg);
      }
    );
  }

  addHotelOwner() {
    // console.log(this.hotelOwner);
  }

  addHotel() {
    // console.log(this.hotel);
  }
  addRoom() {
    // console.log(this.room);
  }

}
