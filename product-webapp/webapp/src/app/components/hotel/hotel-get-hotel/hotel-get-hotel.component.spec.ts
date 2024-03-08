import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelGetHotelComponent } from './hotel-get-hotel.component';

describe('HotelGetHotelComponent', () => {
  let component: HotelGetHotelComponent;
  let fixture: ComponentFixture<HotelGetHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelGetHotelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelGetHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
