export class BookDto {
  title: string;
  authorName: string;
  language: string

  constructor(title: string, authorName: string, language: string) {
    this.title = title;
    this.authorName = authorName;
    this.language = language;
  }
}
