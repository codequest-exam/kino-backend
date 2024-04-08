package dat3.kino.reservation;

import dat3.security.entity.UserWithRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findAllByShowingId(Long id);

    public List<Reservation> findAllByUser(UserWithRoles user);
}
