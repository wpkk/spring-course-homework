package ru.otus.homework07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getBySurname(String surname);

    Author getByNameAndSurname(String name, String surname);

    @Query("select a from Author a where id = :#{#book?.getId()}")
    Author getByBook(@Param("book") Book book);
}
