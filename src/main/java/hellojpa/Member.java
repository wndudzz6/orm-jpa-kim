package hellojpa;

import jakarta.persistence.*;
import jdk.jfr.Name;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity//JPA를 사용하는 애구나~
public class Member {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) //EnumType.STRING 필수.
    // default = ORDINAL인데 ENUM 수정하다가 순서 바뀌어도 DB에 적용안됨 - 버그 발생
    private RoleType roleType;

    //날짜 타입 DATE TIME TIMESTAMP 이렇게 세 가지
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //최신 하이버네이트는 이거 써라
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    //큰 컨텐츠?
    @Lob
    private String description;

    @Transient //DB와 관련없이 메모리에서만 쓰고싶다 할 때 붙임
    private int temp;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.username = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void setTemp(int temp) {
        this.temp = temp;
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
