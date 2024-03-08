import { TestBed } from '@angular/core/testing';

import { HotelauthGuard } from './hotelauth.guard';

describe('HotelauthGuard', () => {
  let guard: HotelauthGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(HotelauthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
