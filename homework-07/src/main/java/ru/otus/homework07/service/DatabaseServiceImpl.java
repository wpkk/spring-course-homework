package ru.otus.homework07.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;
import ru.otus.homework07.domain.Comment;
import ru.otus.homework07.domain.Genre;
import ru.otus.homework07.domain.partial.PartialBook;
import ru.otus.homework07.repository.*;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PartialBookRepository partialBookRepository;

    private GenreRepository genreRepository;

    private CommentRepository commentRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.getByTitle(title).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public List<Book> getBooksByAuthor(String surname) {
        Author author = authorRepository.getBySurname(surname).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return bookRepository.getByAuthor(author);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        Genre genreObject = genreRepository.getByGenre(genre).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return bookRepository.getByGenre(genreObject);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorByBook(String bookTitle) {
        Book book = bookRepository.getByTitle(bookTitle).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return authorRepository.getByBook(book).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreByBook(String bookTitle) {
        Book book = bookRepository.getByTitle(bookTitle).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return genreRepository.getByBook(book).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentByBook(String bookTitle) {
        PartialBook partialBookObject = partialBookRepository.getPartialBookByTitle(bookTitle).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return commentRepository.getByPartialBook(partialBookObject);
    }

    @Override
    public PartialBook getPartialBookByTitle(String title) {
        return partialBookRepository.getPartialBookByTitle(title).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public long countBooks() {
        return bookRepository.count();
    }

    @Override
    public long countAuthors() {
        return authorRepository.count();
    }

    @Override
    public long countGenres() {
        return genreRepository.count();
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Author> getAuthorById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Genre> getGenreById(long id) {
        return genreRepository.findById(id);
    }

    @Override
    public Author getAuthorByFullName(String name, String surname) {
        return authorRepository.getByNameAndSurname(name, surname).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public Genre getGenreByGenre(String genre) {
        return genreRepository.getByGenre(genre).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void deleteGenre(long id) {
        genreRepository.deleteById(id);
    }
}