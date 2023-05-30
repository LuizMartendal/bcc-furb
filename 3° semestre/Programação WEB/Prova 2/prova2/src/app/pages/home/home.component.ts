import { Component, Output } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  @Output() title = 'Bem vindo(a)!';
  @Output() message = 'Bem-vindo ao nosso site exclusivo para informações dos funcionários! Aqui, você encontrará uma plataforma dedicada a fornecer todas as informações essenciais relacionadas aos colaboradores da nossa empresa. Nosso objetivo é manter todos os funcionários atualizados, fornecer recursos úteis e garantir a transparência em relação a políticas, benefícios e comunicações internas.\nEste site foi criado com o objetivo de fornecer uma fonte centralizada de informações para os funcionários, facilitando o acesso a dados importantes relacionados ao seu emprego. Esperamos que você aproveite o uso deste recurso para obter as informações necessárias e esteja sempre atualizado sobre as informações relevantes da empresa.'
}
