import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/hotelowner/hotelowner.service';

@Component({
  selector: 'app-hotel-get-review',
  templateUrl: './hotel-get-review.component.html',
  styleUrls: ['./hotel-get-review.component.css']
})
export class HotelGetReviewComponent {
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(private http: HttpClient,private getAllReview: HotelownerService) {}
  ngOnInit(): void {
    this.
  getAllDetails()
  }

  getAllDetails() {
    this.getAllReview.getAllReviews().subscribe((data: any) => {
      this.getJsonValue = data;
      
    });
  }


}
