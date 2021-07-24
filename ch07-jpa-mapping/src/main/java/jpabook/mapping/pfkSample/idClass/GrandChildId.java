package jpabook.mapping.pfkSample.idClass;

import java.io.Serializable;

public class GrandChildId implements Serializable {

    private ChildId child; //GrandChild.child 매핑
    private String id; //GrandChild.child 매핑
    //equals, hashCode
}
