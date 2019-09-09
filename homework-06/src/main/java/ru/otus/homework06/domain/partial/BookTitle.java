package ru.otus.homework06.domain.partial;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class BookTitle {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter @Setter
    private String title;

}