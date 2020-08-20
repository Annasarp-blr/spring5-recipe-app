package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private  String description;



    private BigDecimal amount;
    @ManyToOne
    private Recipe recipe;
    @OneToOne (fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

}
