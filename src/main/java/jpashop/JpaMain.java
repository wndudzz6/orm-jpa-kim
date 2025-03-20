package jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpashop.domain.Member;
import jpashop.domain.Order;

public class JpaMain {
    public static void main(String[] args) {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try{
//            Order order = em.find(Order.class, 1L);
//            Long memberId = order.getMember_id();
//
//
//            tx.commit();
//
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//            emf.close();
//        }

    }
}
