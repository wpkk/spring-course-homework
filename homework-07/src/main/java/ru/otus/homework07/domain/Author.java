package ru.otus.homework07.domain;

import lombok.*;
import ru.otus.homework07.dao.converters.YearAttributeConverter;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "authors")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

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
