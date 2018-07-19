import { Injectable } from '@angular/core';
import { BookComponent } from "./book.component";
import { Book } from "./book";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root',
})
export class BookService {
  configUrl = 'assets/config.json';

  constructor(private http: HttpClient) { }

  getConfig() {
    return this.http.get(this.configUrl);
  }

  postData(book: Book) {
    const body = {
      id: book.id,
      title: book.title,
      author: book.author,
      language: book.language,
      publisher: book.publisher
    };
    return this.http.post('http://localhost:8080/book', body);
  }
}
