package ru.otus.homework07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> getBySurname(String surname);

    Optional<Author> getByNameAndSurname(String name, String surname);

    @Query("select a from Author a where id = :#{#book?.getAuthor().getId()}")
    Optional<Author> getByBook(@Param("book") Book book);
}
