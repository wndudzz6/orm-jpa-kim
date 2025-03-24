package jpql;

import jakarta.persistence.*;

@Entity
public class JpqlOrder {

    @Id @GeneratedValue
    private Long id;

    private int orderAmount;

    @Embedded
    private JpqlAddress jpqlAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JPAQLPRODUCT_ID")
    private JpqlProduct jpqlProduct;
}
