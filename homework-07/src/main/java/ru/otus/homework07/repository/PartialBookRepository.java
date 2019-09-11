package ru.otus.homework07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.homework07.domain.partial.PartialBook;

public interface PartialBookRepository extends JpaRepository<PartialBook, Long> {

    PartialBook getPartialBookByTitle(String title);

}
