import { NgIf } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss'],
  standalone: true,
  imports: [MatDialogModule, NgIf],
})

export class DialogCompoment {
  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) {}
}

export interface DialogData {
  status: string;
  message: string;
}
