import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-header',
  templateUrl: './customer-header.component.html',
  styleUrls: ['./customer-header.component.css']
})
export class CustomerHeaderComponent {
  constructor( private router: Router) { }

  ngOnInit(): void {
  }

  isActiveRoute(routePath: string): boolean {
    return this.router.isActive(routePath, true);
  }


  navigateToAdmin(): any {
   
    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/admin-content']) ;
   
  }
  navigateToHotelOwner(): any {
    
    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/hotel-content']) ;
   
  }

  onlogout() {
    
    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/customer-content']);
  }
}
