import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Cadastro2 } from 'src/app/models/cadastro2';

@Injectable({
  providedIn: 'root'
})
export class Cadastro2Service {

  private API_URL: string = 'https://bu.furb.br/mcardoso/progWeb/apiRestAval.php/cadastro/';

  constructor(
    private http: HttpClient
  ) { }

  list(): Observable<Cadastro2[]> {
    return this.http.get<Cadastro2[]>(`${this.API_URL}`);
  }

  getById(id: number): Observable<Cadastro2> {
    return this.http.get<Cadastro2>(`${this.API_URL}/${id}`)
  }

  update(cadastro2: Cadastro2): Observable<any> {
    return this.http.put(`${this.API_URL}`, cadastro2);
  }

  delete(): Observable<any> {
    return this.http.delete(`${this.API_URL}`);
  }
}
