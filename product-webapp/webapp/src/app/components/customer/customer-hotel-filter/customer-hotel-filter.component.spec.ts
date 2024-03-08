import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerHotelFilterComponent } from './customer-hotel-filter.component';

describe('CustomerHotelFilterComponent', () => {
  let component: CustomerHotelFilterComponent;
  let fixture: ComponentFixture<CustomerHotelFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerHotelFilterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerHotelFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
