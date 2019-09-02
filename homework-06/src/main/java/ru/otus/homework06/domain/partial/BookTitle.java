package ru.otus.homework06.domain.partial;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class BookTitle {

    @Getter @Setter
    @Id
    private long id;

    @Getter @Setter
    private String title;

}