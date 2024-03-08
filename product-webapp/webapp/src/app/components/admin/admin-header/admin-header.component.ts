import { Component } from '@angular/core';
import { MatMenuPanel } from '@angular/material/menu';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent {
  menu: MatMenuPanel<any> | null | undefined;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


  navigateToCustomer(): any {

    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/customer-content']);

  }
  navigateToAdmin(): any {

    this.router.navigate(['/admin-content']);

  }

  navigateToHotelOwner(): any {
    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/hotel-content']);

  }

  navigateToUpdateAdminProfile(): any {

    this.router.navigate(['/admin-update-profile']);

  }
  navigateToReviewHotels(): any {

    this.router.navigate(['/admin-review-hotels']);

  }

  onlogout() {

    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/admin-content']);
  }
}

