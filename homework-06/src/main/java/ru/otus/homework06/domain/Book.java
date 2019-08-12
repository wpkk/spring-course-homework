package ru.otus.homework06.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Book {

    @Getter @Setter
    @Id
    @GeneratedValue
    private int id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id")
    private Author author;

    @Getter @Setter
    @ManyToOne(targetEntity = Genre.class)
    @JoinColumn(name = "genre_id")
    private Genre genre;

}