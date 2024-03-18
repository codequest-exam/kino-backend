package dat3.kino.dto;

import dat3.kino.entity.Reservation;
import dat3.security.dto.UserWithRolesResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReservationResponseDto {
    private UserWithRolesResponse user;
    private ShowingResponseDto showing;
private int price;
private List<SeatResponseDto> reservedSeats;

    public ReservationResponseDto(Reservation reservation) {
    }
}
