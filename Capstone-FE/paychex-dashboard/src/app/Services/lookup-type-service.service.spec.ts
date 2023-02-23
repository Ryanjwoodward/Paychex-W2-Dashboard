import { TestBed } from '@angular/core/testing';

import { LookupTypeServiceService } from './lookup-type-service.service';

describe('LookupTypeServiceService', () => {
  let service: LookupTypeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LookupTypeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
