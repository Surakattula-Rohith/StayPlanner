import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelUpdateHotelComponent } from './hotel-update-hotel.component';

describe('HotelUpdateHotelComponent', () => {
  let component: HotelUpdateHotelComponent;
  let fixture: ComponentFixture<HotelUpdateHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelUpdateHotelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelUpdateHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
