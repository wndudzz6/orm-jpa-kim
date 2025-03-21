package join_inheritance;

import jakarta.persistence.*;

//구현 클래스마다 테이블 전략은 생략 아무도 원하지 않음
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //조인전략이 정석이지만 싱글도 고려해볼만함
@DiscriminatorColumn //DTYPE 있는게 좋음
public class Item {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
