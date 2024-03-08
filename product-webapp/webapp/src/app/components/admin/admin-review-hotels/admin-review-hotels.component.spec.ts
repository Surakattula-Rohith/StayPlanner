import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminReviewHotelsComponent } from './admin-review-hotels.component';

describe('AdminReviewHotelsComponent', () => {
  let component: AdminReviewHotelsComponent;
  let fixture: ComponentFixture<AdminReviewHotelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminReviewHotelsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminReviewHotelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
