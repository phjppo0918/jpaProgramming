package practice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

}
