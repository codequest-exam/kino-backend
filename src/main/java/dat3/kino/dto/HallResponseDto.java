package dat3.kino.dto;

import dat3.kino.entity.Cinema;
import dat3.kino.entity.Hall;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HallResponseDto {
    private int roomNumber;
    private Cinema cinema;
    //private int
    public HallResponseDto(Hall hall) {
        this.roomNumber = hall.getRoomNumber();
        this.cinema = hall.getCinema();
    }
}
