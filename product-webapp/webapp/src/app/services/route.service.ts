import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  constructor(private http: HttpClient, private route: Router) { }

  routeToCustomerLogin() {
    this.route.navigate(['/customer-content/customer-login'])
  }
  routeToCustomerHomePage() {
    this.route.navigate(['/customer-content/customer-homepage'])
  }
  routeToCustomerRegister() {
    this.route.navigate(['/customer-content/customer-register'])
  }
  routeToAdminLogin() {
    this.route.navigate(['/admin-content/admin-login'])
  }
  routeToAdminHomePage() {
    this.route.navigate(['/admin-content/admin-homepage'])
  }
  routeToAdminRegister() {
    this.route.navigate(['/admin-content/admin-register'])
  }

  routeToHotelLogin() {
    this.route.navigate(['/hotel-content/hotel-login'])
  }
  routeToHotelHomePage() {
    this.route.navigate(['/hotel-content/hotel-homepage'])
  }
  routeToHotelRegister() {
    this.route.navigate(['/hotel-content/hotel-register'])
  }
}
