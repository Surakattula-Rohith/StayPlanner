import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { RouteService } from 'src/app/services/route.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {

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
      
      this.routeService.routeToAdminHomePage();
    }, err => {
      alert('Invalid Credentails')
    })

  }

}