package dat3.kino.dto;

import dat3.kino.entity.Seat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatResponseDto {
    private int seatNumber;
    private int seatRowNumber;

    public SeatResponseDto(Seat seat) {
        this.seatNumber = seat.getSeatNumber();
        this.seatRowNumber = seat.getSeatRowNumber();
    }
}
