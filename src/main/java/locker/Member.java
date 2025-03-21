package locker;

import jakarta.persistence.*;

//@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    Locker locker;
}
