import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelGetHotelroomComponent } from './hotel-get-hotelroom.component';

describe('HotelGetHotelroomComponent', () => {
  let component: HotelGetHotelroomComponent;
  let fixture: ComponentFixture<HotelGetHotelroomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelGetHotelroomComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelGetHotelroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
