import { TestBed } from '@angular/core/testing';

import { FeedserviceService } from './feedservice.service';

describe('FeedserviceService', () => {
  let service: FeedserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeedserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
