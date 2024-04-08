package dat3.kino.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GroupSizeCategory {
    @Id
    private String name;
    private int minSize;
    private int maxSize;
    public GroupSizeCategory(String name, int minSize, int maxSize) {
        this.name = name;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }
}
