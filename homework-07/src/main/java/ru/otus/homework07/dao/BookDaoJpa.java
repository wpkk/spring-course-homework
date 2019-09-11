package ru.otus.homework07.dao;

import lombok.AllArgsConstructor;
import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;
import org.springframework.stereotype.Repository;
import ru.otus.homework07.domain.Genre;
import ru.otus.homework07.domain.partial.PartialBook;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@AllArgsConstructor
public class BookDaoJpa implements BookDao {

    @PersistenceContext
    private EntityManager em;

    private static final String ENTITY_GRAPH_NAME = "books-entity-graph";

    @Override
    public int count() {
        return em.createQuery("select count(b) from Book b", Long.class).
                getSingleResult().intValue();
    }

    @Override
    public Optional<Book> getById(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public Book getByTitle(String title) {
        return em.createQuery("select b from Book b where title = :title", Book.class).
                setParameter("title", title).
                setHint("javax.persistence.fetchgraph", getEntityGraph()).
                getSingleResult();
    }

    @Override
    public List<Book> getAll() {
        return em.createQuery("select b from Book b", Book.class).
                setHint("javax.persistence.fetchgraph", getEntityGraph()).
                getResultList();
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return em.createQuery("select b from Book b where author_id = :authorId", Book.class).
                setParameter("authorId", author.getId()).
                setHint("javax.persistence.fetchgraph", getEntityGraph()).
                getResultList();
    }

    @Override
    public List<Book> getByGenre(Genre genre) {
        return em.createQuery("select b from Book b where genre_id = :genreId", Book.class).
                setParameter("genreId", genre.getId()).
                setHint("javax.persistence.fetchgraph", getEntityGraph()).
                getResultList();
    }

    @Override
    public void insert(Book book) {
        em.persist(book);
    }

    @Override
    public void deleteById(long id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
    }

    @Override
    public PartialBook getPartialBookByTitle(String title) {
        return em.createQuery("select pb from PartialBook pb where title = :title", PartialBook.class).
                setParameter("title", title).
                getSingleResult();
    }

    private EntityGraph getEntityGraph() {
        return em.getEntityGraph(ENTITY_GRAPH_NAME);
    }
}