package jpabook.mapping.compositeKey.idClass;

import java.io.Serializable;

public class ParentId implements Serializable {

    private String id1;
    private String id2;

    public ParentId() {
    }

    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {

        return false;
    }

    @Override
    public int hashCode() {
        return -1;
    }
}
