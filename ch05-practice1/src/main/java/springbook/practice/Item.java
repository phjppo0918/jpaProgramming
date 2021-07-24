package springbook.practice;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private Integer price;
    private Integer stockQuantity;

}
