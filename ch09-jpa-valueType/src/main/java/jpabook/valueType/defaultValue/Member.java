package jpabook.valueType.defaultValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;
}
