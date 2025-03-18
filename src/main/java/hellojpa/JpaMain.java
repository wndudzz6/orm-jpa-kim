package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Member member1 = new Member(13L, "aaaa");
            em.persist(member1);
            System.out.println("em.persist(member1 13L aaaa)");
            System.out.println("==아직 DB에 쿼리x==");

            Member findMember = em.find(Member.class, 13L);
            System.out.println("find로 13L찾음, JPA는 영속성 컨텍스트에서 엔티티를 찾음 DB x");
            System.out.println(findMember + "DB가 아닌 영속성 컨텍스트에서 찾은 13L");

            member1.setName("bbbb");
            tx.commit(); //DB에 반영
            System.out.println("aaaa->bbbb(영속성 컨텍스트) / DB엔 처음부터 bbbb로 저장"+member1);


            System.out.println("====준영속 예제===");
            tx.begin();
            Member member2 = new Member(17L, "cccc");
            em.persist(member2);
            em.flush(); // DB에 바로 반영
            System.out.println("==(flush)17L cccc DB에 저장: "+member2+"==");

            em.detach(member2); // member 엔티티를 준영속 상태로 전환
            member2.setName("dddd"); // 준영속 상태에서 변경해도 DB에 반영되지 않음
            tx.commit();
            System.out.println("준영속 상태 dddd로 변경"+member2);

            //삭제 작업 예제
            System.out.println("==삭제작업==");
            tx.begin();
            Member memberToClear = new Member(18L, "clear");
            System.out.println("18L clear 등록");
            em.persist(memberToClear);
            em.clear(); // 영속성 컨텍스트 내 모든 엔티티가 제거됨 - 모든 엔티티가 준영속 상태
            System.out.println("영속성 컨텍스트 내 18L clear의 모든 엔티티가 제거됨");
            tx.commit(); // DB에서도 해당 엔티티가 삭제됨
            List<Member> clearMembers = em.createQuery("select m from Member m", Member.class).getResultList();
            for (Member clearMember : clearMembers) {
                System.out.println("Member = " + clearMember);
            }
            System.out.println("18L clear 없음");

            System.out.println("JPQL 쿼리 사용==");
            //JPQL 사용 쿼리 실행 시 JPA는 자동으로 플러시를 호출해서 DB에 반영한다.
            Member flushMember = new Member(19L, "eeee");
            em.persist(flushMember);
            System.out.println("permist(19L eeee)함");
            // 아래 JPQL 실행 전 자동 플러시 발생
            List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
            System.out.println("JPQL 쿼리로 flush가 호출되어 DB에 저장됨");
            for (Member member : members) {
                System.out.println(member);;
            }
            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }
}
