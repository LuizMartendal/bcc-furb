import { Component } from '@angular/core';
import { SnackBarComponent } from './shared/snack-bar/snack-bar.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  durationInSeconds = 5

  constructor(
    private snackBar: MatSnackBar
  ) {}

  openSnackBar(msg: string) {
    this.snackBar.openFromComponent(SnackBarComponent, {
      duration: this.durationInSeconds * 1000,
      data: {
        message: msg
      }
    });
  }
}
