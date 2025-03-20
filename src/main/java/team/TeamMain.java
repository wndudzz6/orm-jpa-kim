package team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;


public class TeamMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            //연관관계의 주인 - 자주 하는 실수
            TeamMember teamMember = new TeamMember();
            teamMember.setUsername("member1");
            em.persist(teamMember);

            Team team = new Team();
            team.setName("TeamA");
            team.getTeamMembers().add(teamMember); //멤버의 팀을 결정하는 것은 멤버가 아님
            //member1의 team은 teamA가 아니라 null.
            em.persist(team);

            em.flush();
            em.clear();

//            TeamMember findTeamMember = em.find(TeamMember.class, teamMember.getId());
//            List<TeamMember> teamMembers = findTeamMember.getTeam().getTeamMembers();
//            for (TeamMember member : teamMembers) {
//                System.out.println("TeamMember: " + member.getUsername());
//            }


            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }
}
