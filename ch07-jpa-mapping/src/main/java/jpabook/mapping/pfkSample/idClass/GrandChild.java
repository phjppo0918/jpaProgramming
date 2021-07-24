package jpabook.mapping.pfkSample.idClass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId.class)
@Getter
@Setter
public class GrandChild {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="parent_id"),
            @JoinColumn(name="child_id")
    })
    public Child child;

    @Id @Column(name = "grandchild_id")
    private String id;

    private String name;
}
