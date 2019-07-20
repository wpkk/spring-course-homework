package ru.otus.homework05.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework05.dao.AuthorDao;
import ru.otus.homework05.dao.BookDao;
import ru.otus.homework05.dao.GenreDao;
import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;

import java.util.List;

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
//        Genre genre1 = genreDao.getBy
        return null;
    }

    @Override
    public List<Author> getAllAuthors() {
        return null;
    }

    @Override
    public List<Genre> getAllGenres() {
        return null;
    }
}
