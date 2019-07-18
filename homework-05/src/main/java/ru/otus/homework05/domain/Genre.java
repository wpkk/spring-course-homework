package ru.otus.homework05.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @ToString
public class Genre {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String genre;

}
