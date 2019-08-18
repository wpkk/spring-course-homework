package ru.otus.homework06.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
@AllArgsConstructor
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Comment comment) {
        em.persist(comment);
    }

    @Override
    public Comment getByBook(Book book) {
        return em.createQuery("select c from Comment where book_id = :bookId", Comment.class).
                setParameter("bookId", book.getId()).
                getSingleResult();
    }
}