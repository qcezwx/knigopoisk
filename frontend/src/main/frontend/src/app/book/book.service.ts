import {Injectable} from '@angular/core';
import {Book} from "./book";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root',
})
export class BookService {
  configUrl = 'assets/config.json';

  constructor(private http: HttpClient) {
  }

  getConfig() {
    return this.http.get(this.configUrl);
  }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>("http://localhost:8080/book");
  }

  getBookById(id: number): Observable<Book> {
    return this.http.get<Book>(`http://localhost:8080/book/${id}`)
  }

  getBooksByGenre(genre: string): Observable<Book[]> {
    return this.http.get<Book[]>(`http://localhost:8080/book/genre/${genre}`)
  }

}
