package jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpashop.domain.*;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

            Member member = new Member();
            member.setName("hello");

            em.persist(member);

            em.flush();
            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
            //쿼리가 나가지 않음 프록시를 통해 엔티티를 조회함
            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember.id = " + findMember.getId()); //DB 접근을 요구x. 엔티티의 식별자는 이미 알고 있음
            System.out.println("식별자가 아닌 값 출력 ==== DB 접근 ");
            System.out.println("findMember.name = "+findMember.getName()); //DB 접근 요구o 실제 엔티티 데이터가 필요함 : 프록시 초기화

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }
}
