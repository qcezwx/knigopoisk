export class Book {
  id: number;
  title: string;
  author: string;
  language: string;
  publisher: string;

  constructor(id: number, title: string, author: string, language: string, publisher: string) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.language = language;
    this.publisher = publisher;
  }
}
