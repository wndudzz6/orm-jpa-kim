package join_inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import join_inheritance.Item;

@Entity
public class Album extends Item {
    private String artist;
}
