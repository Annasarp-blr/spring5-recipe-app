package guru.springframework.domain;

import guru.springframework.domain.enums.Difficulty;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServTime() {
        return servTime;
    }

    public void setServTime(Integer servTime) {
        this.servTime = servTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }
    public Difficulty getLevel() {
        return level;
    }

    public void setLevel(Difficulty level) {
        this.level = level;
    }
    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDirectons() {
        return directons;
    }

    public void setDirectons(String directons) {
        this.directons = directons;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
