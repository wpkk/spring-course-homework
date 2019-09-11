package ru.otus.homework07.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework07.domain.Comment;
import ru.otus.homework07.domain.partial.PartialBook;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Override
    @EntityGraph("comments-entity-graph")
    List<Comment> findAll();

    @EntityGraph("comments-entity-graph")
    List<Comment> getByPartialBook(PartialBook partialBookObject);
}
