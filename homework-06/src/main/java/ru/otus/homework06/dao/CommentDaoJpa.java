package ru.otus.homework06.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.homework06.domain.Comment;
import ru.otus.homework06.domain.partial.BookTitle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class CommentDaoJpa implements CommentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Comment comment) {
        em.persist(comment);
    }

    @Override
    public List<Comment> getByBookTitle(BookTitle bookTitle) {
        return em.createQuery("select c from Comment c where book_id = :bookId", Comment.class).
                setParameter("bookId", bookTitle.getId()).
                getResultList();
    }

    @Override
    public List<Comment> getAll() {
        return em.createQuery("select c from Comment c", Comment.class).
                getResultList();
    }

}