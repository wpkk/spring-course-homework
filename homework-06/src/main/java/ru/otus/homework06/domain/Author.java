package ru.otus.homework06.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Year;

@Entity
@Table(name = "authors")
@AllArgsConstructor @ToString
public class Author {

    @Getter @Setter
    @Id
    @GeneratedValue
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String surname;

    @Getter @Setter
    private Year birth;

    @Getter @Setter
    private Year death;

}
