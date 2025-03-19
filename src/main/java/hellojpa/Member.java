package hellojpa;


public class Member {

    private Long id;

    private String username;


    public Member(){

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + username + '\'' +
                '}';
    }
}
