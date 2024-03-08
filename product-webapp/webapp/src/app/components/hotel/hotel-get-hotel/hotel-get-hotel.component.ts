import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-get-hotel',
  templateUrl: './hotel-get-hotel.component.html',
  styleUrls: ['./hotel-get-hotel.component.css']
})
export class HotelGetHotelComponent {
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(private http: HttpClient, private getAllService: HotelownerService) { }
  ngOnInit() {
    this.
      getAllDetails()
  }

  getAllDetails() {
    this.getAllService.getAllHotels().subscribe((data: any) => {
      this.getJsonValue = data;

    });
  }

  deletehotel(id: String) {
    this.getAllService.deletebyhotelid(id).subscribe((response: any) => {
      if (response.success) {
        alert("Hotel Data Deleted succesfully")
      }
    })
  }



}
