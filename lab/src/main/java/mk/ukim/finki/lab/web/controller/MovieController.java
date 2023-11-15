package mk.ukim.finki.lab.web.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.service.MovieService;
import mk.ukim.finki.lab.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final ProductionService productionService;

    @GetMapping
    public String getMoviesPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("movies", movieService.listAll());
        return "/listMovies.html";
//        return "add-movie.html";
    }

    @PostMapping("/add")
    public String saveMovie(@RequestParam String movieTitle, @RequestParam String summary, @RequestParam double rating, @RequestParam Long id){
        movieService.addMovie(movieTitle, summary, rating, id);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{movieId}")
    public String editMovie(@PathVariable Long movieId, Model model){
        Optional<Movie> movie = movieService.findById(movieId);
        if(movie.isPresent()){
            Movie m = movie.get();
            model.addAttribute("productions", productionService.findAll());
            model.addAttribute("movie",m);
            return "add-movie";
        }
        return "redirect:/movies"; //TODO error message
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie( @PathVariable Long id ){
        movieService.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping("/add-form")
    public String getAddMoviePage( Model model ){
        model.addAttribute("productions", productionService.findAll());
        return "add-movie";
    }

    @GetMapping("/movies/edit-form/{id}")
    public String getEditMovieForm( @PathVariable Long id, Model model ){
        Optional<Movie> m = movieService.findById(id);
        if(m.isPresent()){
            Movie movie = m.get();
            model.addAttribute("productions", productionService.findAll());
            model.addAttribute("movie",movie);
            return "add-movie";
        }
        return "redirect:/movies?error=MovieNotValid";
    }

}
