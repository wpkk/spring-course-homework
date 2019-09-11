package ru.otus.homework07.domain;

import lombok.*;
import ru.otus.homework07.domain.partial.BookTitle;

import javax.persistence.*;

@NamedEntityGraph(
        name = "comments-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("bookTitle"),
        }
)
@Entity
@Table(name = "comments")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String comment;
    
    @Getter @Setter
    @ManyToOne(targetEntity = BookTitle.class)
    @JoinColumn(name = "book_id")
    private BookTitle bookTitle;

}
