package ru.otus.homework06.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ConstantConditions")
@Repository
@Transactional
@AllArgsConstructor
public class AuthorDaoJpa implements AuthorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int count() {
        return em.createQuery("select count(a) from Author a", Long.class)
                .getSingleResult().intValue();
    }

    @Override
    public Optional<Author> getById(int id) {
        return Optional.ofNullable(em.find(Author.class, id));
    }

    @Override
    public Author getBySurname(String surname) {
        return em.createQuery("select a from Author a where surname = :surname", Author.class).
                setParameter("surname", surname).
                getSingleResult();
    }

    @Override
    public Author getByFullName(String name, String surname) {
        return em.createQuery("select a from Author a where name = :name and surname = :surname", Author.class).
                setParameter("name", name).
                setParameter("surname", surname).
                getSingleResult();
    }

    @Override
    public Author getByBook(Book book) {
        return em.createQuery("select a from Author a where id = :id", Author.class).
                setParameter("id", book.getAuthor().getId()).
                getSingleResult();
    }

    @Override
    public List<Author> getAll() {
        return em.createQuery("select a from Author a", Author.class).getResultList();
    }

    @Override
    public void insert(Author author) {
        em.persist(author);
    }

    @Override
    public int deleteById(int id) {
        Author author = em.find(Author.class, id);
        em.remove(author);
        return 1;
    }
}
