package guru.springframework.domain;

import guru.springframework.domain.enums.Difficulty;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe", fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
    @EqualsAndHashCode.Exclude
    private Set<Ingredient> ingredients = new HashSet<>();

    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Notes notes;



    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_category",
            joinColumns =  @JoinColumn(name="recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))

    @EqualsAndHashCode.Exclude
    private Set<Categories> categories;

    @Version
    private int version;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

}
