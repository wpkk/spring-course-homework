package ru.otus.homework07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework07.domain.partial.PartialBook;

import java.util.Optional;

public interface PartialBookRepository extends JpaRepository<PartialBook, Long> {

    Optional<PartialBook> getPartialBookByTitle(String title);

}
