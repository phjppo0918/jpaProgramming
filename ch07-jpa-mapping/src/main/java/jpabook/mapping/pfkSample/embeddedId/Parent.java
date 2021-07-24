package jpabook.mapping.pfkSample.embeddedId;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Parent {
    @Id @Column(name = "parent_id")
    private String id;

    private String name;
}

