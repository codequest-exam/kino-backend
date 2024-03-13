package dat3.kino.repository;

import dat3.kino.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findAllByShowingId(Long id);
}
