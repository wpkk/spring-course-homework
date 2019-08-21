package ru.otus.homework06.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@AllArgsConstructor
public class GenreDaoJpa implements GenreDao {

    @PersistenceContext
    private EntityManager em;
    @Override
    public int count() {
        return em.createQuery("select count(g) from Genre g", Long.class)
                .getSingleResult() .intValue();
    }

    @Override
    public Optional<Genre> getById(int id) {
        return Optional.ofNullable(em.find(Genre.class, id));
    }

    @Override
    public Genre getByGenre(String genre) {
        return em.createQuery("select g from Genre g where g.genre = :genre", Genre.class)
                .setParameter("genre", genre)
                .getSingleResult();
    }

    @Override
    public Genre getByBook(Book book) {
        return em.createQuery("select g from Genre g where g.id = :id", Genre.class)
                .setParameter("id", book.getGenre().getId())
                .getSingleResult();
    }

    @Override
    public List<Genre> getAll() {
    return em.createQuery("select g from Genre g", Genre.class).getResultList();
    }

    @Override
    public void insert(Genre genre) {
        em.persist(genre);
    }

    @Override
    public void deleteById(int id) {
        Genre genre = em.find(Genre.class, id);
        em.remove(genre);
    }

}
