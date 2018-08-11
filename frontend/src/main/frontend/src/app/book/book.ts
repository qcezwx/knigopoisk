export class Book {
  id: number;
  title: string;
  author: {
    fullname: string
  };
  publicationYear: number;
  language: string;
  genre: {
    genreName: string
  }[];
  rating: number;
  totalValues: number;

  constructor(id: number, title: string, author: { fullname: string }, publicationYear: number, language: string, genre: { genreName: string }[], rating: number, totalValues: number) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.language = language;
    this.genre = genre;
    this.rating = rating;
    this.totalValues = totalValues;
  }
}
