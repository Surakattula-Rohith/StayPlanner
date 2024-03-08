import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { HotelOwner } from 'src/app/model/HotelOwner';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/services/admin/admin.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-review-hotels',
  templateUrl: './admin-review-hotels.component.html',
  styleUrls: ['./admin-review-hotels.component.css'],
})
export class AdminReviewHotelsComponent {
  ngOnInit(): void {

    this.getHotelOwnerListFromServer();
  }


  hotelOwner: HotelOwner;
  hotelOwnerlist: Array<HotelOwner>;
  admin: Admin;
  errorMsg: string = 'Error occured while submission.';

  constructor(
    private adminService: AdminService,

  ) {
    this.admin = new Admin();
    this.hotelOwnerlist = [];
    this.hotelOwner = new HotelOwner();
  }

  getHotelOwnerListFromServer() {
    this.adminService.getHotelOwner().subscribe((response) => {
      this.hotelOwnerlist = response;
    });
  }

  showHotels() {
    this.getHotelOwnerListFromServer();
  }

  changeHotelOwnerStatus(currentHotelOwner: HotelOwner) {
    const tempOwner = currentHotelOwner;
    if (tempOwner.aprovedbyadmin == false) {
      tempOwner.aprovedbyadmin = true;
    } else {
      tempOwner.aprovedbyadmin = false;
    }
    currentHotelOwner = tempOwner

    this.adminService.updateHotelOwner(currentHotelOwner);
  }
}
