package jpabook.mapping.compositeKey.EmbeddedId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParentId implements Serializable {

    @Column(name = "parent_id1")
    private String id1;

    @Column(name = "parent_id2")
    private String id2;

    @Override
    public boolean equals(Object o) {

        return false;
    }

    @Override
    public int hashCode() {
        return -1;
    }

}
