package sec6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpashop.domain.Member;


public class TeamMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            TeamMember teamMember = new TeamMember();
            teamMember.setUsername("member1");
            teamMember.setTeamId(team.getTeamId());
            em.persist(teamMember);

            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }
}
