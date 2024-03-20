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
    private boolean isDiscount;

    public TicketPriceModifier(String name, double priceModifierPercent, boolean isDiscount) {
        this.name = name;
        this.priceModifierPercent = priceModifierPercent;
        this.isDiscount = isDiscount;
    }

    public TicketPriceModifier(String name, double priceModifierPercent) {
        this.name = name;
        this.priceModifierPercent = priceModifierPercent;
        this.isDiscount = priceModifierPercent < 0;
    }
}
