package dat3.kino.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TicketPriceModifier {
    @Id
    private String name;
    private double priceModifierPercent;
    private boolean isPositive;

    public TicketPriceModifier(String name, double priceModifierPercent, boolean isPositive) {
        this.name = name;
        this.priceModifierPercent = priceModifierPercent;
        this.isPositive = isPositive;
    }
}
