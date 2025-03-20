package team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;


public class TeamMain {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try{
//            Team team = new Team();
//            team.setName("TeamA");
//            //member1의 team은 teamA가 아니라 null.
//            em.persist(team);
//
//            TeamMember teamMember = new TeamMember();
//            teamMember.setUsername("member1");
//            teamMember.changeTeam(team); //JPA 입장에선 이렇게까지만 하면 됨
//            em.persist(teamMember);
//
//            //그런데 객체지향적으로는 양쪽에 값을 다 넣어줘야함.
//            //양방향 매핑이 아니라 단방향 매핑이 2개이므로
//            //물론 주인에서만 넣어도 지연로딩으로 객체에 저장이 된다.
//
//            //team.getTeamMembers().add(teamMember); //지우고 teamMember에서 부를 때마다 호출되게끔 한다.
//
////            em.flush(); //em.flush(), em.clear()를 하면 팀에서 멤버를 추가 안해도 DB에서 갖고와서 ㄱㅊ긴한데...
////            em.clear();
//
//            TeamMember findTeamMember = em.find(TeamMember.class, teamMember.getId());
//            List<TeamMember> teamMembers = findTeamMember.getTeam().getTeamMembers();
//            System.out.println("=============================");
//            for (TeamMember member : teamMembers) {
//                System.out.println("TeamMember: " + member.getUsername());
//            }
//            System.out.println("=============================");
//            //DB에서는 member1이 team에 잘 조회가 됨 하지만 여기에선 출력이 되지 않는다.
//            //자바에서는 캐시에 안 들어가니까 넣을 때는 항상 양쪽에 값을 설정해야 한다.
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
