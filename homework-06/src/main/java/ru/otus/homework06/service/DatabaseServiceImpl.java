package ru.otus.homework06.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework06.dao.AuthorDao;
import ru.otus.homework06.dao.BookDao;
import ru.otus.homework06.dao.CommentDao;
import ru.otus.homework06.dao.GenreDao;
import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Comment;
import ru.otus.homework06.domain.Genre;
import ru.otus.homework06.domain.partial.BookTitle;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {

    private BookDao bookDao;

    private AuthorDao authorDao;

    private GenreDao genreDao;

    private CommentDao commentDao;

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
    public List<Comment> getAllComments() {
        return commentDao.getAll();
    }

    @Override
    public List<Comment> getCommentByBook(String bookTitle) {
        BookTitle bookTitleObject = bookDao.getBookTitleByTitle(bookTitle);
        return commentDao.getByBookTitle(bookTitleObject);
    }

    @Override
    public BookTitle getBookTitleByTitle(String title) {
        return bookDao.getBookTitleByTitle(title);
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
    public Optional<Book> getBookById(long id) {
        return bookDao.getById(id);
    }

    @Override
    public Optional<Author> getAuthorById(long id) {
        return authorDao.getById(id);
    }

    @Override
    public Optional<Genre> getGenreById(long id) {
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
    public void addComment(Comment comment) {
        commentDao.insert(comment);
    }
    @Override
    public void deleteBook(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public void deleteAuthor(long id) {
        authorDao.deleteById(id);
    }

    @Override
    public void deleteGenre(long id) {
        genreDao.deleteById(id);
    }


}