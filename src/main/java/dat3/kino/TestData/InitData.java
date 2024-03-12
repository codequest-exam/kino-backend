public class InitData {

       public void run(String... args) {

              cinemaRepository.save();

              movieRepository.save();

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

