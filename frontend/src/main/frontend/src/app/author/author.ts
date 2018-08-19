export class Author {
  id: number;
  fullname: string;
  birthDate: string;
  deathDate: string;
  rating: number;
  books: string[];

  constructor(id: number, fullname: string, birthDate: string, deathDate: string, rating: number, books: string[]) {
    this.id = id;
    this.fullname = fullname;
    this.birthDate = birthDate;
    this.deathDate = deathDate;
    this.rating = rating;
    this.books = books;
  }
}
