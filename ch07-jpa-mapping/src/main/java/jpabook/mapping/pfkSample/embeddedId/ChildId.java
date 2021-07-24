package jpabook.mapping.pfkSample.embeddedId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChildId implements Serializable {

    private String parentId; // @MapId("parentId")로 매핑

    @Column(name = "child_id")
    private String id;

    //equals hashCode
}
