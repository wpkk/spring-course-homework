package ru.otus.homework06.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework06.dao.AuthorDao;
import ru.otus.homework06.dao.BookDao;
import ru.otus.homework06.dao.GenreDao;
import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Genre;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {

    private BookDao bookDao;

    private AuthorDao authorDao;

    private GenreDao genreDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookDao.getByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String surname) {
        Author author = authorDao.getBySurname(surname);
        return bookDao.getByAuthor(author);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        Genre genreObject = genreDao.getByGenre(genre);
        return bookDao.getByGenre(genreObject);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

    @Override
    public Author getAuthorByBook(String bookTitle) {
        Book book = bookDao.getByTitle(bookTitle);
        return authorDao.getByBook(book);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAll();
    }

    @Override
    public Genre getGenreByBook(String bookTitle) {
        Book book = bookDao.getByTitle(bookTitle);
        return genreDao.getByBook(book);
    }

    @Override
    public int countBooks() {
        return bookDao.count();
    }

    @Override
    public int countAuthors() {
        return authorDao.count();
    }

    @Override
    public int countGenres() {
        return genreDao.count();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public Optional<Author> getAuthorById(int id) {
        return authorDao.getById(id);
    }

    @Override
    public Optional<Genre> getGenreById(int id) {
        return genreDao.getById(id);
    }

    @Override
    public Author getAuthorByFullName(String name, String surname) {
        return authorDao.getByFullName(name, surname);
    }

    @Override
    public Genre getGenreByGenre(String genre) {
        return genreDao.getByGenre(genre);
    }

    @Override
    public void addBook(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void addAuthor(Author author) {
        authorDao.insert(author);
    }

    @Override
    public void addGenre(Genre genre) {
        genreDao.insert(genre);
    }

    @Override
    public void deleteBook(int id) {
        if (bookDao.deleteById(id) == 0)
            throw new IllegalArgumentException();
    }

    @Override
    public void deleteAuthor(int id) {
        if (authorDao.deleteById(id) == 0)
            throw new IllegalArgumentException();
    }

    @Override
    public void deleteGenre(int id) {
        if (genreDao.deleteById(id) == 0)
            throw new IllegalArgumentException();
    }
}