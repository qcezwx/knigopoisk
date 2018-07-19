import { Component, OnInit } from '@angular/core';
import {BookService} from "./book.service";
import {Book} from "./book";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  book: Book;

  constructor(private bookService: BookService) { }

  submit() {
    this.bookService.postData(this.book)
      .subscribe(
        (data: Book) => {
          this.book = data;
        },
        error => console.log(error)
      );
  }

  ngOnInit() {
    this.submit();
  }

}
