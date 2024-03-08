import { Component } from '@angular/core';

@Component({
  selector: 'app-customer-homepage',
  templateUrl: './customer-homepage.component.html',
  styleUrls: ['./customer-homepage.component.css']
})
export class CustomerHomepageComponent {
  showFilters = false;
  selectedLocation: string = 'all';
  selectedPriceRange: string = 'all';
  hotelNameFilterText: string = '';

  toggleFilters() {
    this.showFilters = !this.showFilters;
    
  }
}
