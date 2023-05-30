import { Component, Output } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  @Output() title = 'Bem vindo(a)!';
  @Output() message = 'Descrição da aplicação'
}
