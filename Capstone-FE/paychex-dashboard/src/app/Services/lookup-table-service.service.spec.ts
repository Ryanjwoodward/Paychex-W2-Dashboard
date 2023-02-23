import { TestBed } from '@angular/core/testing';

import { LookupTableServiceService } from './lookup-table-service.service';

describe('LookupTableServiceService', () => {
  let service: LookupTableServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LookupTableServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
