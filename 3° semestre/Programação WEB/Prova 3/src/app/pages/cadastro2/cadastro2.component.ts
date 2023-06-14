import { Component, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { MatDialog } from '@angular/material/dialog';
import { Cadastro2Service } from 'src/app/core/entidades/cadastro2/cadastro2.service';
import { Cadastro2 } from 'src/app/models/cadastro2';
import { DialogCompoment } from 'src/app/shared/dialog/dialog.component';

@Component({
  selector: 'app-cadastro2',
  templateUrl: './cadastro2.component.html',
  styleUrls: ['./cadastro2.component.scss']
})
export class Cadastro2Component implements OnInit {

  @Output() title = 'Requisições para a prova 3';
  @Output() message = '';

  cadastro2: Cadastro2 | undefined;
  id: number | undefined;

  formCadastro2: FormGroup = this.formBuilder.group({
    id: [null, [Validators.required]],
    nome: [null, [Validators.required]],
    departamento: [null, [Validators.required]],
    endereco: [null, [Validators.required]],
    email: [null, [Validators.required]]
  });

  constructor(
    private service: Cadastro2Service,
    private dialog: MatDialog,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.patchForm();
  }

  list() {

  }

  getById() {
    if (this.id != null) {
      this.service.getById(this.id)
        .subscribe({
          next: (res: any) => {
            console.log(res);

            if (res == null) {
              this.openDialog('Erro', 'Não encontrado');
            } else {
              this.cadastro2 = res;
              this.patchForm();
            }
          }
      });
    }
  }

  delete() {
    this.service.delete()
      .subscribe({
        next: (res: any) => {
          this.openDialog(res.status, res.mensagem);
        }
    });
  }

  update() {
    const formValues = this.formCadastro2.value;
    if (this.cadastro2) {
      this.cadastro2.id = formValues.id;
      this.cadastro2.nome = formValues.nome;
      this.cadastro2.departamento = formValues.departamento;
      this.cadastro2.endereco = formValues.endereco;
      this.cadastro2.email = formValues.email;

      this.service.update(this.cadastro2)
      .subscribe({
        next: (res: any) => {
          this.openDialog(res.status, res.mensagem);
        }
    });
    }
  }

  private openDialog(status: string, message: string) {
    this.dialog.open(DialogCompoment, {
      data: {
        status: status,
        message: message
      },
      width: '250px'
    })
  }

  private patchForm() {
    if (this.cadastro2) {
      this.formCadastro2.patchValue(this.cadastro2);
    }
  }
}
