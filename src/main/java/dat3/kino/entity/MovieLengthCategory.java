package dat3.kino.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MovieLengthCategory {
    @Id
    private String name;

    private int maxMinutes;

   private int minMinutes;

    public MovieLengthCategory() {
    }

    public MovieLengthCategory(String name,
                               int minMinutes,
                               int maxMinutes) {
        this.name = name;
        this.maxMinutes = maxMinutes;
        this.minMinutes = minMinutes;
    }

    public MovieLengthCategory(String name, int minMinutes) {
        this.name = name;
        this.minMinutes = minMinutes;
    }
}
