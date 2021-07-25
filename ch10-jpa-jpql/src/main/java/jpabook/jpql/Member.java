package jpabook.jpql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Member")
public class Member {

    @Id
    private String id;

    private String username;
}
