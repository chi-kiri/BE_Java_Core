package Exercise01;
import java.util.ArrayList;

public class MovieManager<T extends Movie> {
    private ArrayList<T> movies = new ArrayList<>();

    public void addMovie(T movie) {
        movies.add(movie);
    }

    public T findById(int id) {
        for (T movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public boolean deleteMovie(int id) {
        T movie = findById(id);

        if (movie != null) {
            movies.remove(movie);
            return true;
        }

        return false;
    }

    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("Danh sách phim trống!");
            return;
        }

        System.out.println("Danh sách phim:");

        for (T movie : movies) {
            System.out.println(movie);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;

        for (T movie : movies) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Phim tìm thấy: " + movie);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy phim");
        }
    }

    public void filterByRating(double minRating) {
        boolean found = false;

        System.out.println("Phim có rating lớn hơn " + minRating + ":");

        for (T movie : movies) {
            if (movie.getRating() > minRating) {
                System.out.println(movie);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy phim phù hợp.");
        }
    }
}
