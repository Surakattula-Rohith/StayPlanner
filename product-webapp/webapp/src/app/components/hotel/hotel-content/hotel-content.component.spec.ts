import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelContentComponent } from './hotel-content.component';

describe('HotelContentComponent', () => {
  let component: HotelContentComponent;
  let fixture: ComponentFixture<HotelContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelContentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
