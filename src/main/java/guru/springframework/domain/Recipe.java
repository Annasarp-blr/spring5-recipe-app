package guru.springframework.domain;

import guru.springframework.domain.enums.Difficulty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servTime;
    private String source;
    private String url;
    private String directons;
    @Enumerated(value = EnumType.STRING)
    private Difficulty level;
    @Lob
    private Byte[] image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @OneToOne(cascade =  CascadeType.ALL)
    private Notes notes;



    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns =  @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Categories> categories;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

}
