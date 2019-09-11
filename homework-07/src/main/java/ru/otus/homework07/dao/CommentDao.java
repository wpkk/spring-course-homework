package ru.otus.homework07.dao;

import ru.otus.homework07.domain.Comment;
import ru.otus.homework07.domain.partial.PartialBook;

import java.util.List;

public interface CommentDao {

    void insert(Comment comment);

    List<Comment> getByBookTitle(PartialBook partialBook);

    List<Comment> getAll();
}
