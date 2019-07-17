DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(ID INT PRIMARY KEY, TITLE VARCHAR(255), AUTHOR_ID INT , GENRE_ID INT);

DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(ID INT PRIMARY KEY, NAME VARCHAR(255), SURNAME VARCHAR(255), YEAR_BIRTH INT, YEAR_DEATH INT);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES(ID INT PRIMARY KEY, GENRE VARCHAR(255));