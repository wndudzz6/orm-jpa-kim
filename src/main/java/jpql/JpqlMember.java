package jpql;

import jakarta.persistence.*;

@Entity
public class JpqlMember {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JPQLTEAM_ID")
    private JpqlTeam team;

    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "JpqlMember{" +
                "age=" + age +
                ", id=" + id +
                ", username='" + username + '\''+
                '}';
    }
}
