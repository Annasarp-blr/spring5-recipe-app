package guru.springframework.controllers.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;



    @OneToOne
    private  Reciepe reciepe;

    @Lob
    private String notes;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reciepe getReciepe() {
        return reciepe;
    }

    public void setReciepe(Reciepe reciepe) {
        this.reciepe = reciepe;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
