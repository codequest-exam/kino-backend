package dat3.kino.repository;

import dat3.kino.seat.PriceClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceClassRepository extends JpaRepository<PriceClass, String> {
}
