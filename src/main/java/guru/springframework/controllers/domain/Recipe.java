package guru.springframework.controllers.domain;

import guru.springframework.controllers.domain.enums.Difficulty;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

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
    private Categories categories;


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

    public String getDirectons() {
        return directons;
    }

    public void setDirectons(String directons) {
        this.directons = directons;
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

}
