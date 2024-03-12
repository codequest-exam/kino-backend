public class InitData {

       public void run(String... args) {

              Cinema cinema1 = new Cinema("Cineplex Odeon", "123 Main Street");
              Cinema cinema2 = new Cinema("AMC Theatres", "456 Elm Street");

              cinemaRepository.save(cinema1);
              cinemaRepository.save(cinema2);

              // Creating cinema halls for cinema 1
              CinemaHall hall1 = new CinemaHall(cinema1.getId(), 1, true, false, 10, 15);
              CinemaHall hall2 = new CinemaHall(cinema1.getId(), 2, true, true, 12, 20);

              // Creating cinema halls for cinema 2
              CinemaHall hall3 = new CinemaHall(cinema2.getId(), 1, false, false, 8, 10);
              CinemaHall hall4 = new CinemaHall(cinema2.getId(), 2, true, true, 10, 15);
              CinemaHall hall5 = new CinemaHall(cinema2.getId(), 3, true, false, 10, 15);
              CinemaHall hall6 = new CinemaHall(cinema2.getId(), 4, false, true, 8, 12);

              // Saving cinema halls to the repository
              cinemaHallRepository.save(hall1);
              cinemaHallRepository.save(hall2);
              cinemaHallRepository.save(hall3);
              cinemaHallRepository.save(hall4);
              cinemaHallRepository.save(hall5);
              cinemaHallRepository.save(hall6);

              // Creating showings for cinema 1, hall 1
              Showing showing1 = new Showing(movie1.getId(), hall1.getId(), 0, 7200, true, false, 10.0);
              Showing showing2 = new Showing(movie2.getId(), hall1.getId(), 0, 7200, true, false, 12.0);

              // Creating showings for cinema 1, hall 2
              Showing showing3 = new Showing(movie3.getId(), hall2.getId(), 3600, 10800, false, true, 15.0);
              Showing showing4 = new Showing(movie4.getId(), hall2.getId(), 3600, 10800, false, false, 8.0);

              // Creating showings for cinema 2, hall 1
              Showing showing5 = new Showing(movie5.getId(), hall3.getId(), 0, 7200, true, false, 12.0);
              Showing showing6 = new Showing(movie6.getId(), hall3.getId(), 0, 7200, true, true, 15.0);

              // Creating showings for cinema 2, hall 2
              Showing showing7 = new Showing(movie7.getId(), hall4.getId(), 0, 7200, false, true, 10.0);
              Showing showing8 = new Showing(movie8.getId(), hall4.getId(), 3600, 10800, true, true, 18.0);

              // Saving showings to the repository
              showingRepository.save(showing1);
              showingRepository.save(showing2);
              showingRepository.save(showing3);
              showingRepository.save(showing4);
              showingRepository.save(showing5);
              showingRepository.save(showing6);
              showingRepository.save(showing7);
              showingRepository.save(showing8);

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

              movieRepository.save(movie1);
              movieRepository.save(movie2);
              movieRepository.save(movie3);
              movieRepository.save(movie4);
              movieRepository.save(movie5);
              movieRepository.save(movie6);
              movieRepository.save(movie7);
              movieRepository.save(movie8);
              movieRepository.save(movie9);
              movieRepository.save(movie10);
       }
}

