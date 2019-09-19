package ru.otus.homework07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.homework07.domain.Book;
import ru.otus.homework07.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Optional<Genre> getByGenre(String genre);

    @Query("select g from Genre g where id = :#{#book?.getGenre().getId()}")
    Optional<Genre> getByBook(@Param("book") Book book);
}