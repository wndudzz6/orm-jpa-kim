package locker;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    Locker locker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //모든 DB 테이블에 같은 속성이 필요하다면? - 속성만 상속받아서 쓰고 싶은데?
    //Mapped Superclass - 매핑 정보 상속
//    private String createBy;
//    private LocalDateTime createDate;
//    private String lastModifiedBy;
//    private LocalDateTime lastModifiedDate;
}
