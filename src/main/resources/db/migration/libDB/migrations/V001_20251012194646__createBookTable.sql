CREATE TABLE books(
    book_id SERIAL PRIMARY KEY,
    book_title VARCHAR(150) NOT NULL,
    author_id SERIAL,
    isbn VARCHAR (100) NOT NULL,
    published_year SERIAL NOT NULL,
    available_copies SERIAL NOT NULL
    )