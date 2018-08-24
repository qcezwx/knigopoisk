import {Injectable} from '@angular/core';
import {Book} from "./book";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

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
    return this.http.get<Book[]>("http://localhost:8080/api/book");
  }

  getBookById(id: number): Observable<Book> {
    return this.http.get<Book>(`http://localhost:8080/api/book/${id}`)
  }

  getBooksByGenre(genre: string): Observable<Book[]> {
    return this.http.get<Book[]>(`http://localhost:8080/api/book/genre/${genre}`)
  }

  deleteBook(book: Book| number): Observable<Book> {
    const id = typeof book === 'number' ? book : book.id;

    return this.http.delete<Book>(`http://localhost:8080/api/book/${id}`, httpOptions)
  }

  addBook (book: Book): Observable<Book> {
    return this.http.post<Book>(`http://localhost:8080/api/book`, book, httpOptions)
  }
}
