package dat3.kino.dto;

import dat3.kino.entity.Hall;
import dat3.kino.entity.Showing;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShowingResponseDto {
    private MovieResponseDto movie;
    private HallResponseDto hall;
    private LocalDateTime startTime;


    public ShowingResponseDto(Showing showing) {
        this.movie = new MovieResponseDto(showing.getMovie());
        this.hall = new HallResponseDto(showing.getHall());
        this.startTime = showing.getStartTime();
    }


}
