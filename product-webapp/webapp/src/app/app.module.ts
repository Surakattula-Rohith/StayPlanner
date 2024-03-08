import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import {MatExpansionModule} from '@angular/material/expansion';
import {MatStepperModule} from '@angular/material/stepper';


import {MatInputModule} from '@angular/material/input';


import { HttpClientModule } from '@angular/common/http';

import {MatMenuModule} from '@angular/material/menu';
import { MatCardModule } from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './components/customer/customer-register/customer-register.component';
import { CustomerHeaderComponent } from './components/customer/customer-header/customer-header.component';
import { CustomerFooterComponent } from './components/customer/customer-footer/customer-footer.component';
import { CustomerHomepageComponent } from './components/customer/customer-homepage/customer-homepage.component';
import { CustomerContentComponent } from './components/customer/customer-content/customer-content.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { AdminRegisterComponent } from './components/admin/admin-register/admin-register.component';
import { AdminHomepageComponent } from './components/admin/admin-homepage/admin-homepage.component';
import { AdminHeaderComponent } from './components/admin/admin-header/admin-header.component';
import { AdminFooterComponent } from './components/admin/admin-footer/admin-footer.component';
import { AdminContentComponent } from './components/admin/admin-content/admin-content.component';
import { HotelRegisterComponent } from './components/hotel/hotel-register/hotel-register.component';
import { HotelLoginComponent } from './components/hotel/hotel-login/hotel-login.component';
import { HotelHomepageComponent } from './components/hotel/hotel-homepage/hotel-homepage.component';
import { HotelHeaderComponent } from './components/hotel/hotel-header/hotel-header.component';
import { HotelFooterComponent } from './components/hotel/hotel-footer/hotel-footer.component';
import { HotelContentComponent } from './components/hotel/hotel-content/hotel-content.component';
import { LandingPageComponent } from './components/wildcards/landing-page/landing-page.component';
import { PageNotFoundComponent } from './components/wildcards/page-not-found/page-not-found.component';
import { AdminUpdateProfileComponent } from './components/admin/admin-update-profile/admin-update-profile.component';
import { AdminReviewHotelsComponent } from './components/admin/admin-review-hotels/admin-review-hotels.component';
import { ReviewComponent } from './components/wildcards/review/review.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminAddAdminComponent } from './components/admin/admin-add-admin/admin-add-admin.component';
import { PaymentComponent } from './components/payment/payment.component';
import { HotelAddHotelownerComponent } from './components/hotel/hotel-add-hotelowner/hotel-add-hotelowner.component';
import { HotelUpdateHotelownerComponent } from './components/hotel/hotel-update-hotelowner/hotel-update-hotelowner.component';
import { HotelGetHotelComponent } from './components/hotel/hotel-get-hotel/hotel-get-hotel.component';
import { HotelGetOwnerComponent } from './components/hotel/hotel-get-owner/hotel-get-owner.component';
import { HotelGetReviewComponent } from './components/hotel/hotel-get-review/hotel-get-review.component';
import { HotelGetPaymentComponent } from './components/hotel/hotel-get-payment/hotel-get-payment.component';
import { CustomerExploreCityComponent } from './components/customer/customer-explore-city/customer-explore-city.component';
import { CustomerHotelFilterComponent } from './components/customer/customer-hotel-filter/customer-hotel-filter.component';
import { BookingComponent } from './components/booking/booking.component';
import { CustomerAddCustomerComponent } from './components/customer/customer-add-customer/customer-add-customer.component';
import { CustomerUpdateCustomerComponent } from './components/customer/customer-update-customer/customer-update-customer.component';
import { HotelAddOwnerComponent } from './components/hotel/hotel-add-owner/hotel-add-owner.component';
import { HotelAddhotelbyowneridHotelComponent } from './components/hotel/hotel-addhotelbyownerid-hotel/hotel-addhotelbyownerid-hotel.component';
import { HotelAddroombyhotelidHotelComponent } from './components/hotel/hotel-addroombyhotelid-hotel/hotel-addroombyhotelid-hotel.component';
import { HotelGetHotelroomComponent } from './components/hotel/hotel-get-hotelroom/hotel-get-hotelroom.component';
import { HotelGetbyhotelidHotelComponent } from './components/hotel/hotel-getbyhotelid-hotel/hotel-getbyhotelid-hotel.component';
import { HotelUpdateHotelComponent } from './components/hotel/hotel-update-hotel/hotel-update-hotel.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerLoginComponent,
    CustomerRegisterComponent,
    CustomerHeaderComponent,
    CustomerFooterComponent,
    CustomerHomepageComponent,
    CustomerContentComponent,
    AdminLoginComponent,
    AdminRegisterComponent,
    AdminHomepageComponent,
    AdminHeaderComponent,
    AdminFooterComponent,
    AdminContentComponent,
    HotelRegisterComponent,
    HotelLoginComponent,
    HotelHomepageComponent,
    HotelHeaderComponent,
    HotelFooterComponent,
    HotelContentComponent,
    LandingPageComponent,
    PageNotFoundComponent,
    AdminUpdateProfileComponent,
    AdminReviewHotelsComponent,
    ReviewComponent,
    AdminAddAdminComponent,
    PaymentComponent,
    HotelAddHotelownerComponent,
    HotelUpdateHotelownerComponent,
    HotelGetHotelComponent,
    HotelGetOwnerComponent,
    HotelGetReviewComponent,
    HotelGetPaymentComponent,
    CustomerExploreCityComponent,
    CustomerHotelFilterComponent,
    BookingComponent,
    CustomerAddCustomerComponent,
    CustomerUpdateCustomerComponent,
    HotelAddOwnerComponent,
    HotelAddhotelbyowneridHotelComponent,
    HotelAddroombyhotelidHotelComponent,
    HotelGetHotelroomComponent,
    HotelGetbyhotelidHotelComponent,
    HotelUpdateHotelComponent
 

  ],
  imports: [
    BrowserModule,
    MatCardModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule ,
    MatToolbarModule, MatButtonModule, MatIconModule,
    MatSidenavModule,MatListModule,
    MatMenuModule,
    MatExpansionModule
    ,MatInputModule, NgbModule,MatStepperModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
