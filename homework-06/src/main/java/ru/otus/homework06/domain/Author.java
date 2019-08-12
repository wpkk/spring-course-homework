package ru.otus.homework06.domain;

import lombok.*;
import ru.otus.homework06.dao.converters.YearAttributeConverter;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "authors")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String surname;

    @Column(name = "year_birth")
    @Convert(converter = YearAttributeConverter.class)
    @Getter @Setter
    private Year birth;

    @Column(name = "year_death")
    @Convert(converter = YearAttributeConverter.class)
    @Getter @Setter
    private Year death;

}
