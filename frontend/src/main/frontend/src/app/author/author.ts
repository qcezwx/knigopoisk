export class Author {
  id: number;
  fullname: string;
  birthDate: string;
  deathDate: string;
  rating: number;
  titles: {
    id: number;
    title: string;
  }[];

  constructor(id: number, fullname: string, birthDate: string, deathDate: string, rating: number, titles: { id: number; title: string }[]) {
    this.id = id;
    this.fullname = fullname;
    this.birthDate = birthDate;
    this.deathDate = deathDate;
    this.rating = rating;
    this.titles = titles;
  }
}
