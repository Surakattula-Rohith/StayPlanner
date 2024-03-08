import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelAddHotelownerComponent } from './hotel-add-hotelowner.component';

describe('HotelAddHotelownerComponent', () => {
  let component: HotelAddHotelownerComponent;
  let fixture: ComponentFixture<HotelAddHotelownerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelAddHotelownerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelAddHotelownerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
