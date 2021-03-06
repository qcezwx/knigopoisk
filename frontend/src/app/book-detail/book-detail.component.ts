import {Component, OnDestroy, OnInit} from '@angular/core';
import {Book} from "../book/book";
import {BookService} from "../book/book.service";
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit, OnDestroy {
  book: Book;
  color: String = '#D6D9E3';
  id: number;
  selectedValue: number;
  private sub: any;

  constructor(private route: ActivatedRoute,
              private bookService: BookService) {
  }

  delete(book: Book): void {
    this.bookService.deleteBook(book).subscribe();
  }

  getBookById(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.bookService.getBookById(id)
      .subscribe(book => this.book = book);
  }

  addBookValue(): void {
    this.bookService.addBookValue(this.book, this.selectedValue).subscribe();
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; //

      this.getBookById();
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
