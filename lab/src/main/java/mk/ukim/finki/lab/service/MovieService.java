package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.Production;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);

    Optional<Movie> addMovie(String movieTitle, String summary, double rating, Long id);

    Optional<Movie> findById(long id);

    void deleteById(Long id);
}
