import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelAddroombyhotelidHotelComponent } from './hotel-addroombyhotelid-hotel.component';

describe('HotelAddroombyhotelidHotelComponent', () => {
  let component: HotelAddroombyhotelidHotelComponent;
  let fixture: ComponentFixture<HotelAddroombyhotelidHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelAddroombyhotelidHotelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelAddroombyhotelidHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
