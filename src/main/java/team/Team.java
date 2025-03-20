package team;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long teamId;

    private String name;

    //가짜 매핑 - 주인의 반대편
    @OneToMany (mappedBy = "team") //mappedBy는 연관관계의 주인이 아님. 읽기만 가능
    private List<TeamMember> teamMembers = new ArrayList<>();

    //연관관계의 주인과 별개로 어떤 메소드를 통해 넣을지는 내가 선택하면 된다
    //근데 한군데에서만 해야한다. 이 메소드는 팀에서 멤버를 정하는 메소드
//    public void addMember(TeamMember teamMember) {
//        teamMember.setTeam(this);
//        teamMembers.add(teamMember);
//    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
