package guru.springframework.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
public class Categories {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;
    private String description;

    @ManyToMany(mappedBy="categories")
    @EqualsAndHashCode.Exclude
    private Set<Recipe> recipe;

}
