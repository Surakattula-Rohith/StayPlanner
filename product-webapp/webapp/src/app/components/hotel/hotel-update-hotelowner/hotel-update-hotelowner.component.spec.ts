import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelUpdateHotelownerComponent } from './hotel-update-hotelowner.component';

describe('HotelUpdateHotelownerComponent', () => {
  let component: HotelUpdateHotelownerComponent;
  let fixture: ComponentFixture<HotelUpdateHotelownerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelUpdateHotelownerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelUpdateHotelownerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
