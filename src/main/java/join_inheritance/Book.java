package join_inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import join_inheritance.Item;

//@Entity
public class Book extends Item {
    private String author;
    private String isbn;
}
