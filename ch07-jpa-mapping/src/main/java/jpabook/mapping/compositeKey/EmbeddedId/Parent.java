package jpabook.mapping.compositeKey.EmbeddedId;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Parent {
    @EmbeddedId
    private ParentId id;

    private String name;
}
