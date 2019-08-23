insert into authors (ID, NAME, SURNAME, YEAR_BIRTH, YEAR_DEATH) values (default, 'name1', 'author1', '197000', '2000');
insert into authors (ID, NAME, SURNAME, YEAR_BIRTH, YEAR_DEATH) values (default, 'name2', 'author2', '1973', '2003');
insert into authors (ID, NAME, SURNAME, YEAR_BIRTH, YEAR_DEATH) values (default, 'name3', 'author3', '1975', '2005');

insert into genres (ID, GENRE) values (default, 'genre1');
insert into genres (ID, GENRE) values (default, 'genre2');
insert into genres (ID, GENRE) values (default, 'genre3');
insert into genres (ID, GENRE) values (default, 'genre4');

insert into books (ID, TITLE, AUTHOR_ID, GENRE_ID) values (default, 'title1', 2, 3);
insert into books (ID, TITLE, AUTHOR_ID, GENRE_ID) values (default, 'title2', 1, 4);
insert into books (ID, TITLE, AUTHOR_ID, GENRE_ID) values (default, 'title3', 1, 2);