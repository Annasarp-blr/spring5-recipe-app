package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode
public class Notes {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private  Recipe recipe;

    @Lob
    private String notes;

}
