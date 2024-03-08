import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-homepage',
  templateUrl: './admin-homepage.component.html',
  styleUrls: ['./admin-homepage.component.css']
})
export class AdminHomepageComponent {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


  navigateToUpdateAdminProfile(): any {

    this.router.navigate(['admin-content//admin-update-profile']);

  }
  navigateToReviewHotels(): any {

    this.router.navigate(['admin-content//admin-review-hotels']);

  }

}
