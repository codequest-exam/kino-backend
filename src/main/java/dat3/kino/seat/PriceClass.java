package dat3.kino.seat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PriceClass {

    @Id
    private String name;
    private double price;

    public PriceClass(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
