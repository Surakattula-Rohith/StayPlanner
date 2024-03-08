import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelFooterComponent } from './hotel-footer.component';

describe('HotelFooterComponent', () => {
  let component: HotelFooterComponent;
  let fixture: ComponentFixture<HotelFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelFooterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
