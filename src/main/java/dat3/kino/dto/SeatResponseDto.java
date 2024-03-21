package dat3.kino.dto;

import dat3.kino.entity.PriceClass;
import dat3.kino.entity.Seat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatResponseDto {
    private Long id;
    private int seatNumber;
    private int seatRowNumber;
    //    private PriceClass priceClass;
    private double price;

    public SeatResponseDto(Seat seat) {
        this.id = seat.getId();
        this.seatNumber = seat.getSeatNumber();
        this.seatRowNumber = seat.getSeatRowNumber();
        this.price = seat.getPriceClass().getPrice();
        //this.priceClass = seat.getPriceClass();
    }
}
