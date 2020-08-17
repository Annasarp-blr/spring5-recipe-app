package guru.springframework.controllers.domain;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

public class Ingredient {
    private  String description;
    private BigDecimal amount;
    @ManyToOne
    private Recipe recipe;
    @OneToOne (fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    public String getDescription() {
        return description;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
