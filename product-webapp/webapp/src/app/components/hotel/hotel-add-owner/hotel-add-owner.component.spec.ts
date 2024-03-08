import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelAddOwnerComponent } from './hotel-add-owner.component';

describe('HotelAddOwnerComponent', () => {
  let component: HotelAddOwnerComponent;
  let fixture: ComponentFixture<HotelAddOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelAddOwnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotelAddOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
