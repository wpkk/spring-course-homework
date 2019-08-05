package ru.otus.homework06.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Genre {

    @Getter @Setter
    @Id
    @GeneratedValue
    private int id;

    @Getter @Setter
    private String genre;

}
