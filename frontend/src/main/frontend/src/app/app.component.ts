import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Knigopoisk';
  randomInt = Math.floor(Math.random() * 101) + 1;

  updateRandomBook(): void {
    this.randomInt = Math.floor(Math.random() * 101) + 1;
  }
}
