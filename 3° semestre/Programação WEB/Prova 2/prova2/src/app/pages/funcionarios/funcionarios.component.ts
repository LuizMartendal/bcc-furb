import { Component, OnInit, Output } from '@angular/core';
import { FuncionariosService } from 'src/app/core/entidades/funcionarios.service';
import { Funcionario } from 'src/app/models/funcionario';

@Component({
  selector: 'app-funcionarios',
  templateUrl: './funcionarios.component.html',
  styleUrls: ['./funcionarios.component.scss']
})
export class FuncionariosComponent implements OnInit {

  @Output() title = 'Funcionários';
  @Output() message = 'Abaixo está uma lista de funcionários da empresa';

  funcionarios: Funcionario[] = [];

  constructor(
    private funcionariosService: FuncionariosService
  ) {}

  ngOnInit(): void {
    this.getFuncionarios();
  }

  getFuncionarios() {
    this.funcionariosService.getFuncionarios()
      .subscribe({
        next: (res: any) => this.funcionarios = res,
        error: (err: any) => alert(err)
    });

  }
}
