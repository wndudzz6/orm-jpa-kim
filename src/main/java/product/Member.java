package product;

import jakarta.persistence.*;
import locker.Locker;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT") //새로 생기는 테이블
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "MEMBER")
    private List<MemberProduct> memberProducts = new ArrayList<>();
}
