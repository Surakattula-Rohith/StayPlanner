import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelGetOwnerComponent } from './hotel-get-owner.component';

describe('HotelGetOwnerComponent', () => {
  let component: HotelGetOwnerComponent;
  let fixture: ComponentFixture<HotelGetOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelGetOwnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelGetOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
