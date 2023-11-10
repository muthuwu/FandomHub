import { TestBed } from '@angular/core/testing';

import { LastidService } from './lastid.service';

describe('LastidService', () => {
  let service: LastidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LastidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
