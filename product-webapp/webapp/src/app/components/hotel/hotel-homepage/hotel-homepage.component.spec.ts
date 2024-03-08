import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelHomepageComponent } from './hotel-homepage.component';

describe('HotelHomepageComponent', () => {
  let component: HotelHomepageComponent;
  let fixture: ComponentFixture<HotelHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelHomepageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
