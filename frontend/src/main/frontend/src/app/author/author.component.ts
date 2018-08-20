import {Component, OnInit} from '@angular/core';
import {AuthorService} from "./author.service";
import {Author} from "./author";
import {DataSource} from "@angular/cdk/collections";
import {Observable} from "rxjs/internal/Observable";

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  dataSource = new AuthorDataSource(this.authorService)
  displayedColumns = ['position', 'fullname', 'rating'];
  authors: Author[];

  round(number: number): number {
    let tempNumber = number * 10;
    let roundedTempNumber = Math.round(tempNumber);
    return roundedTempNumber / 10;
  };

  constructor(private authorService: AuthorService) {
  }

  ngOnInit() {
  }
}

export class AuthorDataSource extends DataSource<any> {
  constructor(private authorService: AuthorService) {
    super();
  }

  connect(): Observable<Author[]> {
    return this.authorService.getAllAuthors();
  }

  disconnect() {
  }
}
