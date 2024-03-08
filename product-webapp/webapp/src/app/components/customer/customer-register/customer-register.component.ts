import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent {
  saveForm: FormGroup

  constructor(private formBuilder: FormBuilder, private authService: AuthService) {
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
