export class Book {
  id: number;
  title: string;
  author: {
    fullname: string
  };
  publicationDate: string;
  language: string;
  genres: {
    genreName: string
  }[];
  rating: number;
  totalValues: number;

  constructor(id: number, title: string, author: { fullname: string }, publicationDate: string, language: string, genres: { genreName: string }[], rating: number, totalValues: number) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.publicationDate = publicationDate;
    this.language = language;
    this.genres = genres;
    this.rating = rating;
    this.totalValues = totalValues;
  }
}
