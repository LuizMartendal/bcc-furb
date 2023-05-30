import { Component, Output } from '@angular/core';

@Component({
  selector: 'app-funcionarios',
  templateUrl: './funcionarios.component.html',
  styleUrls: ['./funcionarios.component.scss']
})
export class FuncionariosComponent {

  @Output() title = 'Funcionários';
  @Output() message = 'Abaixo está uma lista de funcionários da empresa';
}
