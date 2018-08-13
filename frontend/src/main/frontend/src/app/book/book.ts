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

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get author(): { fullname: string } {
    return this._author;
  }

  set author(value: { fullname: string }) {
    this._author = value;
  }

  get publicationDate(): string {
    return this._publicationDate;
  }

  set publicationDate(value: string) {
    this._publicationDate = value;
  }

  get language(): string {
    return this._language;
  }

  set language(value: string) {
    this._language = value;
  }

  get genres(): { genreName: string }[] {
    return this._genres;
  }

  set genres(value: { genreName: string }[]) {
    this._genres = value;
  }

  get rating(): number {
    return this._rating;
  }

  set rating(value: number) {
    this._rating = value;
  }

  get totalValues(): number {
    return this._totalValues;
  }

  set totalValues(value: number) {
    this._totalValues = value;
  }
}
