package dat3.kino.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dat3.kino.entity.Hall;
import dat3.kino.entity.Showing;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShowingResponseDto {
    private Long id;
    private MovieResponseDto movie;
    private HallResponseDto hall;
    private LocalDateTime startTime;
    @JsonProperty("is3d")
    private boolean is3d;
    @JsonProperty("isImax")
    private boolean isImax;

    public ShowingResponseDto(Showing showing) {
        this.id = showing.getId();
        this.movie = new MovieResponseDto(showing.getMovie());
        this.hall = new HallResponseDto(showing.getHall());
        this.startTime = showing.getStartTime();
        this.isImax = showing.isImax();
        this.is3d = showing.is3d();
    }


}
