
import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Hotel } from 'src/app/model/Hotel';



@Component({
  selector: 'app-customer-explore-city',
  templateUrl: './customer-explore-city.component.html',
  styleUrls: ['./customer-explore-city.component.css']
})
export class CustomerExploreCityComponent {

  views:any;
  hotelName: string ="";
  hotelAddress: string ="";
  location: string ="";
  price: string ="";

  hotel : Hotel ;
  
  
  constructor(private http: HttpClient,private router: Router) {
    this.hotel = new Hotel() ;
  }

  
 
  ngOnInit(){

    let response =  this.http.get("http://localhost:8083/hotel/viewall");
    response.subscribe((data)=>this.views=data);
   
  }
  // @Output() dataEvent = new EventEmitter<Hotel>();


  bookHotel(tempHotel : Hotel){
    this.router.navigate(['/http://localhost:4200/customer-content/customer-booking']) ;
    // this.dataEvent.emit(tempHotel);
    
  }

  



}
