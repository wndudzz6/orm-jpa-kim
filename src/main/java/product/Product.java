package product;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "PRODUCT")
    private List<MemberProduct> productProducts = new ArrayList<>();

//    @ManyToMany(mappedBy = "products") //양방향
//    private List<Member> members = new ArrayList<>();


}
