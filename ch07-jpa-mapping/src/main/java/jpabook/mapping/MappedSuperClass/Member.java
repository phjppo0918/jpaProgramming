package jpabook.mapping.MappedSuperClass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Member extends BaseEntity {

    private String email;
}
