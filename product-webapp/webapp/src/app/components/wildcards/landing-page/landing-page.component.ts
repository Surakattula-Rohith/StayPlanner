import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent {

  constructor( private router: Router) { }

  ngOnInit(): void {
  }


  navigateToCustomer(): any {
    this.router.navigate(['/customer-content']) ;
   
  }
  navigateToAdmin(): any {
    this.router.navigate(['/admin-content']) ;
   
  }
  navigateToHotelOwner(): any {
    
    this.router.navigate(['/hotel-content']) ;
   
  }
}
