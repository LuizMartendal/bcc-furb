import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Funcionario } from 'src/app/models/funcionario';

@Injectable({
  providedIn: 'root'
})
export class FuncionariosService {

  constructor(
    private http: HttpClient
  ) { }

  getFuncionarios() {
    return this.http.get<Funcionario>('assets/data.json');
  }
}
