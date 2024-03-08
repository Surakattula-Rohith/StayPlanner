import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelAddhotelbyowneridHotelComponent } from './hotel-addhotelbyownerid-hotel.component';

describe('HotelAddhotelbyowneridHotelComponent', () => {
  let component: HotelAddhotelbyowneridHotelComponent;
  let fixture: ComponentFixture<HotelAddhotelbyowneridHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelAddhotelbyowneridHotelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelAddhotelbyowneridHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
