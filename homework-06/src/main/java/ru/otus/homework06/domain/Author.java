package ru.otus.homework06.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Year;

@AllArgsConstructor @ToString
public class Author {
    @Getter @Setter
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
