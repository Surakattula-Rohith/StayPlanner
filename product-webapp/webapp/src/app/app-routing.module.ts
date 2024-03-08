import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { authGuard } from './guard/auth.guard';
import { AdminContentComponent } from './components/admin/admin-content/admin-content.component';
import { CustomerContentComponent } from './components/customer/customer-content/customer-content.component';
import { HotelContentComponent } from './components/hotel/hotel-content/hotel-content.component';
import { LandingPageComponent } from './components/wildcards/landing-page/landing-page.component';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './components/customer/customer-register/customer-register.component';
import { CustomerHomepageComponent } from './components/customer/customer-homepage/customer-homepage.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { AdminRegisterComponent } from './components/admin/admin-register/admin-register.component';
import { AdminHomepageComponent } from './components/admin/admin-homepage/admin-homepage.component';
import { HotelLoginComponent } from './components/hotel/hotel-login/hotel-login.component';
import { HotelHomepageComponent } from './components/hotel/hotel-homepage/hotel-homepage.component';
import { HotelRegisterComponent } from './components/hotel/hotel-register/hotel-register.component';
import { AdminUpdateProfileComponent } from './components/admin/admin-update-profile/admin-update-profile.component';
import { AdminReviewHotelsComponent } from './components/admin/admin-review-hotels/admin-review-hotels.component';
import { AdminAddAdminComponent } from './components/admin/admin-add-admin/admin-add-admin.component';
import { HotelAddHotelownerComponent } from './components/hotel/hotel-add-hotelowner/hotel-add-hotelowner.component';
import { HotelUpdateHotelownerComponent } from './components/hotel/hotel-update-hotelowner/hotel-update-hotelowner.component';
import { HotelGetPaymentComponent } from './components/hotel/hotel-get-payment/hotel-get-payment.component';
import { HotelGetReviewComponent } from './components/hotel/hotel-get-review/hotel-get-review.component';
import { HotelGetHotelComponent } from './components/hotel/hotel-get-hotel/hotel-get-hotel.component';
import { HotelGetOwnerComponent } from './components/hotel/hotel-get-owner/hotel-get-owner.component';
import { AdminauthGuard } from './guard/adminauth.guard';
import { HotelauthGuard } from './guard/hotelauth.guard';
import { BookingComponent } from './components/booking/booking.component';
import { CustomerAddCustomerComponent } from './components/customer/customer-add-customer/customer-add-customer.component';
import { HotelAddOwnerComponent } from './components/hotel/hotel-add-owner/hotel-add-owner.component';
import { HotelAddhotelbyowneridHotelComponent } from './components/hotel/hotel-addhotelbyownerid-hotel/hotel-addhotelbyownerid-hotel.component';
import { HotelAddroombyhotelidHotelComponent } from './components/hotel/hotel-addroombyhotelid-hotel/hotel-addroombyhotelid-hotel.component';
import { HotelUpdateHotelComponent } from './components/hotel/hotel-update-hotel/hotel-update-hotel.component';
import { HotelGetHotelroomComponent } from './components/hotel/hotel-get-hotelroom/hotel-get-hotelroom.component';
import { HotelGetbyhotelidHotelComponent } from './components/hotel/hotel-getbyhotelid-hotel/hotel-getbyhotelid-hotel.component';


const routes: Routes = [
  {
    path: 'admin-content', component: AdminContentComponent,
    children: [
      { path: 'admin-login', component: AdminLoginComponent },
      { path: 'admin-register', component: AdminRegisterComponent },
      { path: 'admin-update-profile', component: AdminUpdateProfileComponent, canActivate: [AdminauthGuard] },
      { path: 'admin-add-admin', component: AdminAddAdminComponent, canActivate: [AdminauthGuard] },
      { path: 'admin-review-hotels', component: AdminReviewHotelsComponent, canActivate: [AdminauthGuard] },
      {
        path: 'admin-homepage', component: AdminHomepageComponent
        , canActivate: [AdminauthGuard]
      },
      { path: '', redirectTo: 'admin-login', pathMatch: 'full' }
    ]
  },
  {
    path: 'customer-content', component: CustomerContentComponent,
    children: [
      { path: 'customer-login', component: CustomerLoginComponent },
      { path: 'customer-register', component: CustomerRegisterComponent },
      { path: 'customer-booking', component: BookingComponent, canActivate: [authGuard] },
      { path: 'customer-add-customer', component: CustomerAddCustomerComponent, canActivate: [authGuard] },
      {
        path: 'customer-homepage', component: CustomerHomepageComponent
        , canActivate: [authGuard]
      },
      { path: '', redirectTo: 'customer-login', pathMatch: 'full' }
    ]

  },
  {
    path: 'hotel-content', component: HotelContentComponent,
    children: [
      { path: 'hotel-login', component: HotelLoginComponent },
      { path: 'hotel-get-payment', component: HotelGetPaymentComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-get-review', component: HotelGetReviewComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-register', component: HotelRegisterComponent },
      { path: 'hotel-get-hotel', component: HotelGetHotelComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-get-owner', component: HotelGetOwnerComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-get-room', component: HotelGetHotelroomComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-add-owner', component: HotelAddOwnerComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-addbyownerid-hotel', component: HotelAddhotelbyowneridHotelComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-addbyhotelid-hotel', component: HotelAddroombyhotelidHotelComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-update-hotel', component: HotelUpdateHotelComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-getbyid-hotel', component: HotelGetbyhotelidHotelComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-add-hotelowner', component: HotelAddHotelownerComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-update-hotelowner', component: HotelUpdateHotelownerComponent, canActivate: [HotelauthGuard] },
      { path: 'hotel-homepage', component: HotelHomepageComponent, canActivate: [HotelauthGuard] },
      { path: '', redirectTo: 'hotel-login', pathMatch: 'full' }
    ]
  },
  { path: 'landing-page', component: LandingPageComponent },
  { path: '', redirectTo: 'landing-page', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
