package jpabook.mapping.pfkSample.embeddedId;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class GrandChild {
    @EmbeddedId
    private GrandChildId id;

    @MapsId("childId") // ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "child_id")
    public Child child;

    private String name;
}
