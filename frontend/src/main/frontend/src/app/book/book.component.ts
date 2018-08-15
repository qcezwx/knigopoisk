import { Component, OnInit } from '@angular/core';
import {BookService} from "./book.service";
import {Book} from "./book";
import {DataSource} from "@angular/cdk/collections";
import {Observable} from "rxjs/internal/Observable";
import {ActivatedRoute} from "@angular/router";
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  dataSource = new BookDataSource(this.bookService)
  displayedColumns = ['position', 'title', 'author', 'rating'];
  books: Book[];

  constructor(private bookService: BookService) { }

  ngOnInit() {}

}

export class BookDataSource extends DataSource<any> {
  constructor(private bookService: BookService) {
    super();
  }
  connect(): Observable<Book[]> {
    return this.bookService.getAllBooks();
  }
  disconnect() {}
}
