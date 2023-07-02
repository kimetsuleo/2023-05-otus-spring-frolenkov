insert into genres(id, title)
values (1, 'Triller'),
       (2, 'Roman'),
       (3, 'Comedy'),
       (4, 'Horror'),
       (5, 'Manga'),
       (6, 'IT'),
       (7, 'Fantasy');

insert into authors(id, firstName, lastName, dof)
values (1, 'Jack', 'London', '1876-01-12'),
       (2, 'Robert', 'Martin', '1952-12-05'),
       (3, 'Anjey', 'Sapkowski', '1948-06-12'),
       (4, 'Oscar', 'Wilde', '1854-10-16'),
       (5, 'Erich', 'Remarque', '1898-06-22'),
       (6, 'Koyoharu', 'Gotouge', '1989-05-05');

insert into books(id, title, author_id, genre_id, publication_at)
values (1, 'The Witcher', 3, 7, '2021-01-01'),
       (2, 'Martin Eden', 1, 2, '1952-01-01'),
       (3, 'Clean Code', 2, 6, '1948-01-01'),
       (4, 'Kimetsu no Yaiba', 6, 7, '1854-01-01'),
       (5, 'The picture of Dorian Grey', 4, 7, '1898-01-01'),
       (6, 'No changes on the Western Front', 5, 2, '1989-01-01');


