package ru.otus.homework06.dao;

import ru.otus.homework06.domain.Comment;
import ru.otus.homework06.domain.partial.BookTitle;

import java.util.List;

public interface CommentDao {

    void insert(Comment comment);

    List<Comment> getByBookTitle(BookTitle bookTitle);

    List<Comment> getAll();
}
