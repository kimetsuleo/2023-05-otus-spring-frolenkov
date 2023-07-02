create table if not exists genres
(
    id    integer primary key,
    title character varying
);

create table if not exists authors
(
    id        integer primary key,
    firstName character varying not null,
    lastName  character varying not null,
    dof       date              not null
);

create table if not exists books
(
    id             integer primary key,
    title          character varying not null,
    author_id      integer           not null,
    genre_id       integer           not null,
    publication_at date              not null,

    foreign key (author_id) references authors (id),
    foreign key (genre_id) references genres (id)
);