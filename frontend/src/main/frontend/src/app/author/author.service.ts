import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Author} from "./author";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  configUrl = 'assets/config.json';

  constructor(private http: HttpClient) {
  }

  getConfig() {
    return this.http.get(this.configUrl);
  }

  getAllAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>("http://localhost:8080/authors");
  }

  getAuthorById(id: number): Observable<Author> {
    return this.http.get<Author>(`http://localhost:8080/authors/${id}`)
  }

}
