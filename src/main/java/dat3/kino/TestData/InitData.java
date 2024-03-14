package dat3.kino.TestData;

import dat3.kino.entity.*;
import dat3.kino.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class InitData implements ApplicationRunner {


       private final MovieRepository movieRepository;

       private final HallRepository hallRepository;

       private final ShowingRepository showingRepository;

       private final CinemaRepository cinemaRepository;

       private final ReservationRepository reservationRepository;

       public InitData(ReservationRepository reservationRepository, MovieRepository movieRepository, HallRepository hallRepository, ShowingRepository showingRepository, CinemaRepository cinemaRepository) {
              this.movieRepository = movieRepository;
              this.hallRepository = hallRepository;
              this.showingRepository = showingRepository;
              this.cinemaRepository = cinemaRepository;
              this.reservationRepository = reservationRepository;
       }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        setupAll();
    }

       public void setupAll() {

              Movie movie1 = new Movie("The Shawshank Redemption", 142 * 60, true);
              Movie movie2 = new Movie("Inception", 148 * 60, true);
              Movie movie3 = new Movie("The Godfather", 175 * 60, false);
              Movie movie4 = new Movie("The Dark Knight", 152 * 60, true);
              Movie movie5 = new Movie("Pulp Fiction", 154 * 60, false);
              Movie movie6 = new Movie("Forrest Gump", 142 * 60, false);
              Movie movie7 = new Movie("The Matrix", 136 * 60, true);
              Movie movie8 = new Movie("The Lord of the Rings: The Fellowship of the Ring", 178 * 60, true);
              Movie movie9 = new Movie("Fight Club", 139 * 60, false);
              Movie movie10 = new Movie("The Silence of the Lambs", 118 * 60, false);

           movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10));

           Cinema cinema1 = new Cinema("Cineplex Odeon", "123 Main Street");
              Cinema cinema2 = new Cinema("AMC Theatres", "456 Elm Street");

              cinemaRepository.save(cinema1);
              cinemaRepository.save(cinema2);

               //Creating cinema halls for cinema 1
              Hall hall1 = new Hall(cinema1, 1, true, false, 10, 15);
           Hall hall2 = new Hall(cinema1, 2, true, true, 12, 20);

              // Creating cinema halls for cinema 2
           Hall hall3 = new Hall(cinema2, 1, false, false, 8, 10);
           Hall hall5 = new Hall(cinema2, 3, true, false, 10, 15);
           Hall hall4 = new Hall(cinema2, 2, true, true, 10, 15);
           Hall hall6 = new Hall(cinema2, 4, false, true, 8, 12);

              // Saving cinema halls to the repository
              hallRepository.save(hall1);
              hallRepository.save(hall2);
              hallRepository.save(hall3);
              hallRepository.save(hall4);
              hallRepository.save(hall5);
              hallRepository.save(hall6);
//
              // Creating showings for cinema 1, hall 1
              Showing showing1 = new Showing(movie1, hall1, 0, 7200, true, false, 10.0);
              Showing showing2 = new Showing(movie2, hall1, 0, 7200, true, false, 12.0);

              // Creating showings for cinema 1, hall 2
              Showing showing3 = new Showing(movie3, hall2, 3600, 10800, false, true, 15.0);
              Showing showing4 = new Showing(movie4, hall2, 3600, 10800, false, false, 8.0);

              // Creating showings for cinema 2, hall 1
              Showing showing5 = new Showing(movie5, hall3, 0, 7200, true, false, 12.0);
              Showing showing6 = new Showing(movie6, hall3, 0, 7200, true, true, 15.0);

              // Creating showings for cinema 2, hall 2
              Showing showing7 = new Showing(movie7, hall4, 0, 7200, false, true, 10.0);
              Showing showing8 = new Showing(movie8, hall4, 3600, 10800, true, true, 18.0);

              // Saving showings to the repository
           showingRepository.saveAll(Arrays.asList(showing1, showing2, showing3, showing4, showing5, showing6, showing7, showing8));

// make reservation with a list of unique seat numbers
           Reservation reservation1 = new Reservation(showing1,100, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
           Reservation reservation2 = new Reservation(showing2,100, List.of(11,12,13,14,15));
           // the list must be unique for each reservation
           Reservation reservation3 = new Reservation(showing3,100, List.of(16,17));
           Reservation reservation4 = new Reservation(showing3,100, List.of(18,19));

              // save the reservations
           reservationRepository.saveAll(Arrays.asList(reservation1, reservation2, reservation3, reservation4));


       }


}

