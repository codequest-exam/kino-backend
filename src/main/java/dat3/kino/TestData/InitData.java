package dat3.kino.TestData;

import dat3.kino.entity.Cinema;
import dat3.kino.entity.Movie;
import dat3.kino.entity.Room;
import dat3.kino.entity.Showing;
import dat3.kino.repository.CinemaRepository;
import dat3.kino.repository.MovieRepository;
import dat3.kino.repository.RoomRepository;
import dat3.kino.repository.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InitData {

       @Autowired
       private MovieRepository movieRepository;
       @Autowired
       private RoomRepository roomRepository;
       @Autowired
       private ShowingRepository showingRepository;
       @Autowired
       private CinemaRepository cinemaRepository;

       public void run(String... args) {

              Cinema cinema1 = new Cinema("Cineplex Odeon", "123 Main Street");
              Cinema cinema2 = new Cinema("AMC Theatres", "456 Elm Street");

              cinemaRepository.save(cinema1);
              cinemaRepository.save(cinema2);

              // Creating cinema halls for cinema 1
              Room hall1 = new Room(cinema1, 1, true, false, 10, 15);
              Room hall2 = new Room(cinema1, 2, true, true, 12, 20);

              // Creating cinema halls for cinema 2
              Room hall3 = new Room(cinema2, 1, false, false, 8, 10);
              Room hall4 = new Room(cinema2, 2, true, true, 10, 15);
              Room hall5 = new Room(cinema2, 3, true, false, 10, 15);
              Room hall6 = new Room(cinema2, 4, false, true, 8, 12);

              // Saving cinema halls to the repository
              roomRepository.save(hall1);
              roomRepository.save(hall2);
              roomRepository.save(hall3);
              roomRepository.save(hall4);
              roomRepository.save(hall5);
              roomRepository.save(hall6);

              // Creating showings for cinema 1, hall 1
//              Showing showing1 = new Showing(movie1.getId(), hall1.getId(), 0, 7200, true, false, 10.0);
//              Showing showing2 = new Showing(movie2.getId(), hall1.getId(), 0, 7200, true, false, 12.0);
//
//              // Creating showings for cinema 1, hall 2
//              Showing showing3 = new Showing(movie3.getId(), hall2.getId(), 3600, 10800, false, true, 15.0);
//              Showing showing4 = new Showing(movie4.getId(), hall2.getId(), 3600, 10800, false, false, 8.0);
//
//              // Creating showings for cinema 2, hall 1
//              Showing showing5 = new Showing(movie5.getId(), hall3.getId(), 0, 7200, true, false, 12.0);
//              Showing showing6 = new Showing(movie6.getId(), hall3.getId(), 0, 7200, true, true, 15.0);
//
//              // Creating showings for cinema 2, hall 2
//              Showing showing7 = new Showing(movie7.getId(), hall4.getId(), 0, 7200, false, true, 10.0);
//              Showing showing8 = new Showing(movie8.getId(), hall4.getId(), 3600, 10800, true, true, 18.0);
//
//              // Saving showings to the repository
//              showingRepository.save(showing1);
//              showingRepository.save(showing2);
//              showingRepository.save(showing3);
//              showingRepository.save(showing4);
//              showingRepository.save(showing5);
//              showingRepository.save(showing6);
//              showingRepository.save(showing7);
//              showingRepository.save(showing8);


       }
}

