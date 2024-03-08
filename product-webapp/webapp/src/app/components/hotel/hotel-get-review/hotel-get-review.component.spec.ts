import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelGetReviewComponent } from './hotel-get-review.component';

describe('HotelGetReviewComponent', () => {
  let component: HotelGetReviewComponent;
  let fixture: ComponentFixture<HotelGetReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelGetReviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelGetReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
