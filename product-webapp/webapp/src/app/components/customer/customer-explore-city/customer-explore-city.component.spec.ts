import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerExploreCityComponent } from './customer-explore-city.component';

describe('CustomerExploreCityComponent', () => {
  let component: CustomerExploreCityComponent;
  let fixture: ComponentFixture<CustomerExploreCityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerExploreCityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerExploreCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
