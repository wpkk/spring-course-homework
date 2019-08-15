package ru.otus.homework06.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework06.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ConstantConditions")

@Repository
@Transactional
@AllArgsConstructor
public class BookDaoJpa implements BookDao {

    @PersistenceContext
    private EntityManager em;

    private final NamedParameterJdbcOperations jdbcOperations;

    private final RowMapper<Book> bookMapper;

    @Override
    public int count() {
        return em.createQuery("select count(b) from Book b", Long.class).
                getSingleResult().intValue();
    }

    @Override
    public Optional<Book> getById(int id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public Book getByTitle(String title) {
        return em.createQuery("select b from Book b where title = :title", Book.class).
                setParameter("title", title).
                getSingleResult();
    }

    @Override
    public List<Book> getAll() {
        return em.createQuery("select b from Book b", Book.class).
                getResultList();
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return em.createQuery("select b from Book b where author_id = :authorId", Book.class).
                setParameter("authorId", author.getId()).
                getResultList();
    }

    @Override
    public List<Book> getByGenre(Genre genre) {
        return em.createQuery("select b from Book b where genre_id = :genreId", Book.class).
                setParameter("genreId", genre.getId()).
                getResultList();
    }

    @Override
    public void insert(Book book) {
        em.persist(book);
    }

    @Override
    public int deleteById(int id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
        return 1;
    }
}
