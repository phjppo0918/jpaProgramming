package jpabook.mapping.pfkSample.embeddedId;

import javax.persistence.Column;
import java.io.Serializable;

public class GrandChildId implements Serializable {

    private ChildId childId; // @MapsId("childId") 매핑

    @Column(name = "grandchild_id")
    private String id;

    //equals,hashCode
}
