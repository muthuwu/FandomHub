import { TestBed } from '@angular/core/testing';

import { OtpserviceService } from './otpservice.service';

describe('OtpserviceService', () => {
  let service: OtpserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OtpserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
