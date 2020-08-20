package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    @OneToOne
    private  Recipe recipe;

    @Lob
    private String notes;

}
