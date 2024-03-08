import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { RouteService } from 'src/app/services/route.service';

@Component({
  selector: 'app-hotel-login',
  templateUrl: './hotel-login.component.html',
  styleUrls: ['./hotel-login.component.css']
})
export class HotelLoginComponent {

  loginForm: FormGroup

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private routeService: RouteService) {
    this.loginForm = this.formBuilder.group({
      mailId: ['', Validators.required],
      password: ['', Validators.required],
    })
  }

  loginUser(loginForm: FormGroup) {
    this.authService.authenicatedUser(this.loginForm.value).subscribe(resp => {
      sessionStorage.setItem('bearerToken', resp['token'])
      
      this.routeService.routeToHotelHomePage();
    }, err => {
      alert('Invalid Credentails')
    })

  }

}

