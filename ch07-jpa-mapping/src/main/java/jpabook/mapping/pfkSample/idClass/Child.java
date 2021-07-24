package jpabook.mapping.pfkSample.idClass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
@Getter
@Setter
public class Child {

    @Id
    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Parent parent;

    @Id
    @Column(name = "child_id")
    private String childId;

    private String name;
}
