package ru.otus.homework06.dao;

import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Comment;

import java.util.List;

public interface CommentDao {

    void insert(Comment comment);

    List<Comment> getByBook(Book book);

    List<Comment> getAll();
}
