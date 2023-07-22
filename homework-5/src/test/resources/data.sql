insert into genres(title)
values ('Triller'),
       ('Roman'),
       ('Comedy'),
       ('Horror'),
       ('Manga'),
       ('IT'),
       ('Fantasy');

insert into authors(firstName, lastName, dof)
values ('Jack', 'London', '1876-01-12'),
       ('Robert', 'Martin', '1952-12-05'),
       ('Anjey', 'Sapkowski', '1948-06-12'),
       ('Oscar', 'Wilde', '1854-10-16'),
       ('Erich', 'Remarque', '1898-06-22'),
       ('Koyoharu', 'Gotouge', '1989-05-05');

insert into books(title, author_id, genre_id, publication_at)
values ('The Witcher', 3, 7, '2021-01-01'),
       ('Martin Eden', 1, 2, '1952-01-01'),
       ('Clean Code', 2, 6, '1948-01-01'),
       ('Kimetsu no Yaiba', 6, 7, '1854-01-01'),
       ('The picture of Dorian Grey', 4, 7, '1898-01-01'),
       ('No changes on the Western Front', 5, 2, '1989-01-01');


