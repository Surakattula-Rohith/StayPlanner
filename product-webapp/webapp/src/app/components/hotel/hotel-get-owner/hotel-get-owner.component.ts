import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-get-owner',
  templateUrl: './hotel-get-owner.component.html',
  styleUrls: ['./hotel-get-owner.component.css']
})
export class HotelGetOwnerComponent {
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(private http: HttpClient, private getAllService: HotelownerService) { }
  ngOnInit(): void {
    this.
      getAllDetails()
  }

  getAllDetails() {
    this.getAllService.getAllOwner().subscribe((data: any) => {
      this.getJsonValue = data;

    });
  }

}
