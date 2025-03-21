package jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpashop.domain.Item;
import jpashop.domain.Member;
import jpashop.domain.Order;
import jpashop.domain.OrderItem;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            tx.begin();

            // Member 엔티티 생성 및 설정
            Member member = new Member();
            member.setName("오주영");

            // Item 엔티티 생성 및 설정
            Item item1 = new Item();
            item1.setName("123");

            // OrderItem 엔티티 생성 및 설정
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item1);

            // Order 엔티티 생성 및 연관관계 설정
            Order order = new Order();
            order.setMember(member);
            order.addOrderItem(orderItem);

            // persist 호출
            em.persist(member);
            em.persist(item1);
            em.persist(order);
            em.persist(orderItem);

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }
}
