package dat3.kino.repository;

import dat3.kino.reservation.TicketPriceModifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPriceModifierRepository extends JpaRepository<TicketPriceModifier, String>{
}
