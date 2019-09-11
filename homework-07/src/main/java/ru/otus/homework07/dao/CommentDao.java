package ru.otus.homework07.dao;

import ru.otus.homework07.domain.Comment;
import ru.otus.homework07.domain.partial.BookTitle;

import java.util.List;

public interface CommentDao {

    void insert(Comment comment);

    List<Comment> getByBookTitle(BookTitle bookTitle);

    List<Comment> getAll();
}
