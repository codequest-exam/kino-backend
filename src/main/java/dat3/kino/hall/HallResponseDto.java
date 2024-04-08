package dat3.kino.hall;

import dat3.kino.cinema.Cinema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HallResponseDto {
    private Long id;
    private int hallNumber;
    private Cinema cinema;
    public HallResponseDto(Hall hall) {
        this.id = hall.getId();
        this.hallNumber = hall.getHallNumber();
        this.cinema = hall.getCinema();
    }
}
