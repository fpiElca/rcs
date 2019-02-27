import { TestBed } from '@angular/core/testing';

import { HaltestellenService } from './haltestellen.service';

describe('HaltestellenService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HaltestellenService = TestBed.get(HaltestellenService);
    expect(service).toBeTruthy();
  });
});
