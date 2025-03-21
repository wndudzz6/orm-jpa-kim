package join_inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
//@DiscriminatorValue("영화") //Dtype에 엔티티 이름 말고 직접 적을 수도 있음
public class Movie extends Item {
    private String director;
    private String actor;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
