package dat3.kino.hall;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {

    Hall findByCinemaId(Long id);
}