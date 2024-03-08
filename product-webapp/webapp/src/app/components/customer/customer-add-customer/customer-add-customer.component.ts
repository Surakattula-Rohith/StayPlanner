

import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { AuthService } from 'src/app/services/auth.service';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-customer-add-customer',
  templateUrl: './customer-add-customer.component.html',
  styleUrls: ['./customer-add-customer.component.css']
})
export class CustomerAddCustomerComponent {
  ngOnInit(): void {
  }


  customer : Customer ;
  errorMsg: string = "Error occured while submission.";

  constructor( private customerService: CustomerService) {

    this.customer = new Customer() ;

  }

 addCustomer() 
  {
    this.customerService.addCustomer(this.customer).subscribe(resp => {
  
      alert("Data Saved");
      this.customer = new Customer ;
    }, error => {
      console.log(this.errorMsg)
    });
  }

}