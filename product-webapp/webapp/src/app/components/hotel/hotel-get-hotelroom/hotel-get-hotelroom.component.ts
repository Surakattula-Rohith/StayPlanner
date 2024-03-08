import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-get-hotelroom',
  templateUrl: './hotel-get-hotelroom.component.html',
  styleUrls: ['./hotel-get-hotelroom.component.css']
})
export class HotelGetHotelroomComponent {
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(private http: HttpClient, private getRoomService: HotelownerService) { }
  ngOnInit(): void {
    this.getAllDetails()
  }

  getAllDetails() {
    this.getRoomService.getAllRoom().subscribe((data: any) => {
      this.getJsonValue = data;
    });
  }
  deleteroom(id: String) {
    this.getRoomService.deletebyroomid(id).subscribe((response: any) => {
      if (response.success) {
        alert("Room  Data  Deleted succesfully")
      }
    })
  }


}







