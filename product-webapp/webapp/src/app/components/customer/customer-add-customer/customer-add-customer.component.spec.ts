import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerAddCustomerComponent } from './customer-add-customer.component';

describe('CustomerAddCustomerComponent', () => {
  let component: CustomerAddCustomerComponent;
  let fixture: ComponentFixture<CustomerAddCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerAddCustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerAddCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
