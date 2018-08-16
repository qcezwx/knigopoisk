import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppComponent} from './app.component';
import {BookComponent} from './book/book.component';
import {RoutingModule} from "./routing/routing.module";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './home/home.component';
import {AuthorComponent} from './author/author.component';
import {UserComponent} from './user/user.component';
import {MaterialModule} from "./material.module";
import {BookDetailComponent} from './book-detail/book-detail.component';
import {MatGridListModule, MatTableModule} from "@angular/material";
import {BookGenreComponent} from "./book-genre/book-genre.component";
import {AuthorDetailComponent} from "./author-detail/author-detail.component";


@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    HomeComponent,
    AuthorComponent,
    AuthorDetailComponent,
    UserComponent,
    BookDetailComponent,
    BookGenreComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    MatTableModule,
    MatGridListModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
