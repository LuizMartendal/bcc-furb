import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FuncionariosService {

  constructor(
    private http: HttpClient
  ) { }

  getFuncionarios() {
    return this.http.get('assets/data.json');
  }
}
