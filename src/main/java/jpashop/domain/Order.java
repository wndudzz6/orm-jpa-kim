package jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "ORDERS") //DB에서 ORDER BY 명령어 떄문에 안될 때가 있어서 ORDERS
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID") //명확하게 하려면 name으로 지정해주기
    private Long member_id; //DB에서는 낙타 안써서 DB 관련으로는 뱀 씀
    private LocalDateTime order_date;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
