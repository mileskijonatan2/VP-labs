package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.Production;
import mk.ukim.finki.lab.service.ProductionService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    public List<Movie> findAll(){
        return DataHolder.movies;
    }

    public List<Movie> searchMovies(String text){
        return DataHolder.movies.stream().filter(m->m.getTitle().contains(text)||m.getSummary().contains(text)).collect(Collectors.toList());
    }

    public Optional<Movie> addMovie(String movieTitle, String summary, double rating, Production p){
        DataHolder.movies.removeIf(m->m.getTitle().equals(movieTitle));
        Movie newMovie = new Movie(movieTitle, summary, rating, p);
        DataHolder.movies.add(newMovie);
        return Optional.of(newMovie);
    }

    public Optional<Movie> findById(long id) {
        return DataHolder.movies.stream().filter(m->m.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        DataHolder.movies.removeIf(m->m.getId().equals(id));
    }
}
