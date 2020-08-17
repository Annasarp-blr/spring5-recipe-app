package guru.springframework.controllers.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    @OneToOne
    private  Recipe reciepe;

    @Lob
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return reciepe;
    }

    public void setRecipe(Recipe reciepe) {
        this.reciepe = reciepe;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
