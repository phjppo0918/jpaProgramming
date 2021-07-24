package jpabook.mapping.pfkSample.embeddedId;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Child {
    @EmbeddedId
    private ChildId id;

    @MapsId("parentId") // ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name="parent_id")
    public Parent parent;

    private String name;
}

