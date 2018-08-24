import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {BookComponent} from "../book/book.component";
import {HomeComponent} from "../home/home.component";
import {BookDetailComponent} from "../book-detail/book-detail.component";
import {BookGenreComponent} from "../book-genre/book-genre.component";
import {AuthorComponent} from "../author/author.component";
import {AuthorDetailComponent} from "../author-detail/author-detail.component";

const routes: Routes = [
  {path: 'book', component: BookComponent},
  {path: 'book/:id', component: BookDetailComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'book/genre/:genre', component: BookGenreComponent},
  {path: 'authors', component: AuthorComponent},
  {path: 'authors/:id', component: AuthorDetailComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class RoutingModule {
}
