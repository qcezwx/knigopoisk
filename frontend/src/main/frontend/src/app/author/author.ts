export class Author {
  id: number;
  fullname: string;
  birthDate: string;
  deathDate: string;

  constructor(id: number, fullname: string, birthDate: string, deathDate: string) {
    this.id = id;
    this.fullname = fullname;
    this.birthDate = birthDate;
    this.deathDate = deathDate;
  }
}
