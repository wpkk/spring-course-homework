package ru.otus.homework07.domain.partial;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class PartialBook {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter @Setter
    private String title;

}