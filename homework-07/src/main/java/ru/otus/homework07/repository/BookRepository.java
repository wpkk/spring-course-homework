package ru.otus.homework07.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;
import ru.otus.homework07.domain.Genre;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    @EntityGraph("books-entity-graph")
    List<Book> findAll();

    @EntityGraph("books-entity-graph")
    Book getByTitle(String title);

    @EntityGraph("books-entity-graph")
    List<Book> getByAuthor(Author author);

    @EntityGraph("books-entity-graph")
    List<Book> getByGenre(Genre genreObject);

}
