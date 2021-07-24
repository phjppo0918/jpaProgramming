package jpabook.mapping.compositeKey.idClass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Child {
    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent_id1" , referencedColumnName = "parent_id1"),
            @JoinColumn(name = "parent_id2" , referencedColumnName = "parent_id2")
            //name과 referencedColumnName 값이 같다면 referencedColumnName 생략가능
    })
    private Parent parent;
}
