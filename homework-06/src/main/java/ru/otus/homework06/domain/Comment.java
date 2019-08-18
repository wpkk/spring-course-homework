package ru.otus.homework06.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String comment;

    @Getter @Setter
    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private Book book;

}
