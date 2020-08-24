package guru.springframework.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode
public class Ingredient {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private  String description;



    private BigDecimal amount;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @EqualsAndHashCode.Exclude
    private Recipe recipe;

    @OneToOne (fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private UnitOfMeasure uom;

}
