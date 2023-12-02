import { TestBed } from '@angular/core/testing';

import { MyforumserviceService } from './myforumservice.service';

describe('MyforumserviceService', () => {
  let service: MyforumserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyforumserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
