import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent {


  ngOnInit(): void {
  }

  isActiveRoute(routePath: string): boolean {
    return this.router.isActive(routePath, true);
  }

  saveForm: FormGroup

  constructor(private formBuilder: FormBuilder, private authService: AuthService,private router: Router) {
    this.saveForm = this.formBuilder.group({
      mailId: ['', Validators.required],
      password: ['', Validators.required],
      userName: ['', Validators.required],
      
    })
  }

  registerUser(saveForm: FormGroup) {
    
    this.authService.registerUser(this.saveForm.value).subscribe(resp => {
      alert("Data Saved");
      this.saveForm.reset();

    })
  }

  
}
