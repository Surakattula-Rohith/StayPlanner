import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-getbyhotelid-hotel',
  templateUrl: './hotel-getbyhotelid-hotel.component.html',
  styleUrls: ['./hotel-getbyhotelid-hotel.component.css']
})
export class HotelGetbyhotelidHotelComponent {
  getJsonValue: any;
  constructor(private http: HttpClient,private getbyIdService: HotelownerService) {}

  getbyid(id :String){
    
    this.getbyIdService.getbyid(id).subscribe((data:any)=>{
      this.getJsonValue = data;
   
    });
  }
  deletehotel(id:String){
    this.getbyIdService.deletebyhotelid(id).subscribe((response: any) => {
      if(response.success){
       alert("Hotel  Data  Deleted succesfully")}
    })
  }


}
