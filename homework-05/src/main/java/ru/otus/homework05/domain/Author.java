package ru.otus.homework05.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Author {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private int yearOfBirth;
    @Getter @Setter
    private int yearOfDeath;

}
