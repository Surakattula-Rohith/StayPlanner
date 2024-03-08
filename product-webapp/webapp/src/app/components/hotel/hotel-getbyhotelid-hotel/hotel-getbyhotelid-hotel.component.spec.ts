import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelGetbyhotelidHotelComponent } from './hotel-getbyhotelid-hotel.component';

describe('HotelGetbyhotelidHotelComponent', () => {
  let component: HotelGetbyhotelidHotelComponent;
  let fixture: ComponentFixture<HotelGetbyhotelidHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelGetbyhotelidHotelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelGetbyhotelidHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
