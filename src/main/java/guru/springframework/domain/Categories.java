package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Categories {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;
    private String description;

    @ManyToMany(mappedBy="categories")
    private Set<Recipe> recipe;

}
