import { Component, OnInit } from '@angular/core';
import {DataSource} from "@angular/cdk/collections";
import {Observable} from "rxjs/internal/Observable";
import {ActivatedRoute} from "@angular/router";
import {Book} from "../book/book";
import {BookService} from "../book/book.service";

@Component({
  selector: 'app-book-genre',
  templateUrl: './book-genre.component.html',
  styleUrls: ['./book-genre.component.css']
})
export class BookGenreComponent implements OnInit {
  dataSource = new BookDataSource(this.route, this.bookService)
  displayedColumns = ['position', 'title', 'author', 'rating'];
  books: Book[];
  genre = this.route.snapshot.paramMap.get('genre');

  constructor(private bookService: BookService,
              private route: ActivatedRoute,) { }

  ngOnInit() {}
}

export class BookDataSource extends DataSource<any> {
  constructor(private route: ActivatedRoute,
              private bookService: BookService) {
    super();
  }
  connect(): Observable<Book[]> {
    const genre = this.route.snapshot.paramMap.get('genre');
      return this.bookService.getBooksByGenre(genre);
  }
  disconnect() {}
}
