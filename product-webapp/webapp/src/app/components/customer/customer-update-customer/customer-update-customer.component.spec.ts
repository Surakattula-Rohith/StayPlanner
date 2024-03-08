import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerUpdateCustomerComponent } from './customer-update-customer.component';

describe('CustomerUpdateCustomerComponent', () => {
  let component: CustomerUpdateCustomerComponent;
  let fixture: ComponentFixture<CustomerUpdateCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerUpdateCustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerUpdateCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
