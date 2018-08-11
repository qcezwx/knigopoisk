import {Component, OnInit} from '@angular/core';
import {Book} from "../book/book";
import {BookService} from "../book/book.service";
import {ActivatedRoute} from '@angular/router';
import 'rxjs/add/operator/map'

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  book: Book;
  resultArray: any;

  constructor(private route: ActivatedRoute,
              private bookService: BookService) {
  }

  // getBookByTitle(): void {
  //   const title = this.route.snapshot.paramMap.get('title');
  //   this.bookService.getBookByTitle(title)
  //     .subscribe(book => this.book = book);
  // }

  getBookByTitle(): void {
    const title = this.route.snapshot.paramMap.get('title');
    this.bookService.getBookByTitle(title)
      .subscribe(book => {
        this.book = book;
        this.resultArray = this.book.map(a => a.genreName);
      });
  }

  ngOnInit() {
    this.getBookByTitle();
  }

}
