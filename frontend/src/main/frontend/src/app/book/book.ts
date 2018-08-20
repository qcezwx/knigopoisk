export class Book {
  private _id: number;
  private _title: string;
  private _author: {
    fullname: string
  };
  private _publicationDate: string;
  private _language: string;
  private _genres: {
    genreName: string
  }[];
  private _rating: number;
  private _totalValues: number;

  constructor(id: number, title: string, author: { fullname: string }, publicationDate: string, language: string, genres: { genreName: string }[], rating: number, totalValues: number) {
    this._id = id;
    this._title = title;
    this._author = author;
    this._publicationDate = publicationDate;
    this._language = language;
    this._genres = genres;
    this._rating = rating;
    this._totalValues = totalValues;
  }
}
