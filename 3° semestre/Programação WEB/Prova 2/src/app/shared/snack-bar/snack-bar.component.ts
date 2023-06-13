import { Component, Inject, Input, inject } from '@angular/core';
import { MAT_SNACK_BAR_DATA, MatSnackBarRef } from '@angular/material/snack-bar';

@Component({
  selector: 'app-snack-bar',
  templateUrl: './snack-bar.component.html',
  styleUrls: ['./snack-bar.component.scss']
})
export class SnackBarComponent {
  @Input() frase: any;
  snackBarRef = inject(MatSnackBarRef);
  message: string = '';

  constructor(
    @Inject(MAT_SNACK_BAR_DATA) data: SnackBarData
  ) {
    this.message = data.message;
  }
}

export interface SnackBarData {
  message: string;
}
