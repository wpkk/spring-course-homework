package ru.otus.homework06.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Genre {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    private String genre;

}
