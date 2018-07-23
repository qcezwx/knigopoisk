import { Component, OnInit } from '@angular/core';
import {BookService} from "./book.service";
import {Book} from "./book";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books: Book[];

  constructor(private bookService: BookService) { }

  submit() {
    this.bookService.getData()
      .subscribe((books) => this.books = books,
        (error) => console.log(error)
      );
  }

  ngOnInit() {
    this.submit();
  }

}
