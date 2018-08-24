import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AuthorService} from "../author/author.service";
import {Author} from "../author/author";

@Component({
  selector: 'app-author-detail',
  templateUrl: './author-detail.component.html',
  styleUrls: ['./author-detail.component.css']
})
export class AuthorDetailComponent implements OnInit, OnDestroy {
  author: Author;
  color: String = '#D6D9E3';
  id: number;
  private sub: any;

  constructor(private route: ActivatedRoute,
              private authorService: AuthorService) {
  }

  getAuthorById(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.authorService.getAuthorById(id)
      .subscribe(author => this.author = author);
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; //

      this.getAuthorById();
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
