import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { RouteService } from 'src/app/services/route.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent {
  loginForm: FormGroup

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private routeService: RouteService) {
    this.loginForm = this.formBuilder.group({
      mailId: ['', Validators.required],
      password: ['', Validators.required],
    })
  }

  loginUser(loginForm: FormGroup) {
    console.log(this.loginForm.value);
    this.authService.authenicatedUser(this.loginForm.value).subscribe(resp => {
      sessionStorage.setItem('bearerToken', resp['token'])
      
      this.routeService.routeToCustomerHomePage();
    }, err => {
      alert('Invalid Credentails')
    })

  }

}
