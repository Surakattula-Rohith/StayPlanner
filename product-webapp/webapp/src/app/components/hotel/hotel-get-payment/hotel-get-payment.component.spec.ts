import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelGetPaymentComponent } from './hotel-get-payment.component';

describe('HotelGetPaymentComponent', () => {
  let component: HotelGetPaymentComponent;
  let fixture: ComponentFixture<HotelGetPaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelGetPaymentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelGetPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
