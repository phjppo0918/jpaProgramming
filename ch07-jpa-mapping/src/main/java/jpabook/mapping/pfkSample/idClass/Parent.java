package jpabook.mapping.pfkSample.idClass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Parent {
    @Id
    @Column(name = "parent_id")
    private String id;
    private String name;
}


