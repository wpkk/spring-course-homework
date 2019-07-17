package ru.otus.homework05.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Book {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private String author;
    @Getter @Setter
    private String genre;

}