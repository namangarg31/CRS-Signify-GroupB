import { TestBed } from '@angular/core/testing';

import { LoginServiceService } from './loginservice.service';

describe('LoginserviceService', () => {
  let service: LoginServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
