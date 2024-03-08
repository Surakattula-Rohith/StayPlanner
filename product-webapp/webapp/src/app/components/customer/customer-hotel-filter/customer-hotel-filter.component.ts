
import { HttpClient, HttpParams } from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from 'src/app/model/Hotel';


@Component({
  selector: 'app-customer-hotel-filter',
  templateUrl: './customer-hotel-filter.component.html',
  styleUrls: ['./customer-hotel-filter.component.css']
})
export class CustomerHotelFilterComponent {
  location: string = '';
  name: string = '';
  hotels: any[] = [];
  temphotel: Hotel;
  price: any;
  showContent: boolean = false;
  selectedSearchOption: string | undefined;

  constructor(private http: HttpClient) {
    this.temphotel = new Hotel();
  }


  searchHotels(): void {
    if (this.selectedSearchOption === 'location') {
      this.getHotelsByLocation(this.location).subscribe(data => {
        this.hotels = data;
      });
    } else if (this.selectedSearchOption === 'name') {
      this.getHotelsByName(this.name).subscribe(data => {

        this.showContent = true;
        this.temphotel = data;
      });
    } else if (this.selectedSearchOption === 'price') {
      this.getHotelsByPrice(this.price).subscribe(data => {
        this.hotels = data;
      });
    } else {

      this.hotels = [];
    }
  }

  getHotelsByName(name: string): Observable<any> {

    return this.http.get('http://localhost:8083/hotel/viewbyname/' + name);

  }

  getHotelsByLocation(location: string): Observable<any> {
    let params = new HttpParams();
    params = params.append('location', location);

    const url = `http://localhost:8083/hotel/viewbyaddr/${location}`;

    return this.http.get<any>(url, { params });
  }

  getHotelsByPrice(maxPrice: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('maxprice', maxPrice.toString());

    const url = `http://localhost:8083/hotel/viewbypricegreaterthan/${maxPrice}`;

    return this.http.get<any>(url, { params });
  }
  bookHotel(tempHotel: Hotel) {

  }

}
