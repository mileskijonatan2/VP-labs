package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.Production;
import mk.ukim.finki.lab.repository.MovieRepository;
import mk.ukim.finki.lab.repository.ProductionRepository;
import mk.ukim.finki.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.searchMovies(text);
    }

    @Override
    public Optional<Movie> addMovie(String movieTitle, String summary, double rating, Long id) {
        Optional<Production> production = productionRepository.findAll().stream().filter(p->p.getId().equals(id)).findFirst();
        return production.map(value -> movieRepository.addMovie(movieTitle, summary, rating, value)).orElse(null);
    }

    @Override
    public Optional<Movie> findById(long id) {
        return movieRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
