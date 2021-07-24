package jpabook.mapping.TablePerConcreteClassStrategy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class Movie extends Item {
    private String author;
    private String isbn;
}