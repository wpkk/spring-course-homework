package ru.otus.homework04.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {

    @Getter
    private final String name;
    @Getter
    private final String surname;

}
