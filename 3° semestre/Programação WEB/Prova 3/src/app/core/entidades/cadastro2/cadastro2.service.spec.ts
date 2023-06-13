import { TestBed } from '@angular/core/testing';

import { Cadastro2Service } from './cadastro2.service';

describe('Cadastro2Service', () => {
  let service: Cadastro2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Cadastro2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
