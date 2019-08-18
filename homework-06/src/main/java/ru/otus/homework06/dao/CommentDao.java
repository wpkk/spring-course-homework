package ru.otus.homework06.dao;

import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Comment;

public interface CommentDao {

    void insert(Comment comment);

    Comment getByBook(Book book);

}
