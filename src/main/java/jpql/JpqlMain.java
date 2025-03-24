package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            JpqlMember member = new JpqlMember();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            TypedQuery<JpqlMember> query = em.createQuery("select m from JpqlMember m", JpqlMember.class);

            List<JpqlMember> result = query.getResultList();
            System.out.println("result = "+result);

            Query query2 = em.createQuery("select m.username, m.age from JpqlMember m", JpqlMember.class);



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
