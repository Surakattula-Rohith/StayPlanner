import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/services/admin/admin.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-update-profile',
  templateUrl: './admin-update-profile.component.html',
  styleUrls: ['./admin-update-profile.component.css']
})
export class AdminUpdateProfileComponent {

  ngOnInit(): void {
  }


  admin : Admin ;
  errorMsg: string = "Error occured while submission.";

  constructor( private adminService: AdminService) {

    this.admin = new Admin() ;

  }

  updateAdmin() 
  {
    this.adminService.updateAdmin(this.admin).subscribe(resp => {
      
      alert("Data Saved");
      this.admin = new Admin ;

    }, error => {
      console.log(this.errorMsg)
    });
  }

 

  
}
