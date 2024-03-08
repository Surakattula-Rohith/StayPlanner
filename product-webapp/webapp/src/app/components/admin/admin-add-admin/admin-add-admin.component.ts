import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/services/admin/admin.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-add-admin',
  templateUrl: './admin-add-admin.component.html',
  styleUrls: ['./admin-add-admin.component.css']
})
export class AdminAddAdminComponent {

  ngOnInit(): void {
  }


  admin: Admin;
  errorMsg: string = "Error occured while submission.";

  constructor(private adminService: AdminService) {

    this.admin = new Admin();

  }

  addAdmin() {
    this.adminService.addAdmin(this.admin).subscribe(resp => {

      alert("Data Saved");
      this.admin = new Admin;
    }, error => {
      console.log(this.errorMsg)
    });
  }


}
