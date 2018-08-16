import {Component, OnInit} from '@angular/core';
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
  dataSource: BookDataSource;
  displayedColumns = ['position', 'title', 'author', 'rating'];
  books: Book[];
  //genre = this.route.snapshot.paramMap.get('genre');
  genre: string;
  private sub: any;

  constructor(private bookService: BookService,
              private route: ActivatedRoute,) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.genre = params['genre'];

      this.dataSource = new BookDataSource(this.route, this.bookService, this.genre);
    });
  }
}

export class BookDataSource extends DataSource<any> {
  constructor(private route: ActivatedRoute,
              private bookService: BookService,
              private genre: string) {
    super();
  }

  connect(): Observable<Book[]> {
    // const genre = this.route.snapshot.paramMap.get('genre');
    return this.bookService.getBooksByGenre(this.genre);
  }

  disconnect() {
  }
}
