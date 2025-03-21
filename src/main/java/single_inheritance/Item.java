package single_inheritance;

import jakarta.persistence.*;

// ITEM이라는 한 테이블 내에 모든 필드가 다 들어감 ex: author, artist . .
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //기본
//@Entity
@DiscriminatorColumn //싱글에서는 안달아도 기본으로 생김
public class Item {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}
