CREATE TABLE IF NOT EXISTS books (
  book_id SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  author_id INTEGER NOT NULL REFERENCES authors(author_id),
  publication_date DATE,
  lang VARCHAR(10),
  rating NUMERIC(2, 1),
  total_values SMALLINT,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  UNIQUE(title, author_id)
);

CREATE TABLE IF NOT EXISTS authors (
  author_id SERIAL PRIMARY KEY,
  fullname VARCHAR(100) NOT NULL UNIQUE,
  birth_date DATE,
  death_date DATE
);
CREATE SEQUENCE author_sequence START WITH 1;

CREATE TABLE IF NOT EXISTS genres (
  genre_id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS book_genre (
  book_id INTEGER NOT NULL REFERENCES genres(genre_id) ON UPDATE CASCADE ON DELETE CASCADE,
  genre_id INTEGER NOT NULL REFERENCES books(book_id) ON UPDATE CASCADE,
  CONSTRAINT book_genre_pkey PRIMARY KEY (book_id, genre_id)

);

CREATE TABLE IF NOT EXISTS quotes (
  quote_id SERIAL PRIMARY KEY,
  book_id INTEGER NOT NULL REFERENCES books(book_id),
  author_id INTEGER NOT NULL REFERENCES books(author_id),
  quote TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS cities (
  id SERIAL PRIMARY KEY,
  name VARCHAR(46) UNIQUE
);