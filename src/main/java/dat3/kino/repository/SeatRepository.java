package dat3.kino.repository;

import dat3.kino.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long>{
    List<Seat> findAllByHallId(Long hallId);
}
