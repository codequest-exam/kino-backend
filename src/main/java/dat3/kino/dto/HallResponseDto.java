package dat3.kino.dto;

import dat3.kino.entity.Cinema;
import dat3.kino.entity.Hall;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HallResponseDto {
    private Long id;
    private int roomNumber;
    private Cinema cinema;
    public HallResponseDto(Hall hall) {
        this.id = hall.getId();
        this.roomNumber = hall.getRoomNumber();
        this.cinema = hall.getCinema();
    }
}
