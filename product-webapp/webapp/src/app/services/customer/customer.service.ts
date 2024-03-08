import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from 'src/app/model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {


  constructor(private http: HttpClient) { }

  addCustomer(customer: Customer) {
    return this.http.post('http://localhost:8090/customers/addcustomer', customer);
  }


}
