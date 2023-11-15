package mk.ukim.finki.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.Production;
import mk.ukim.finki.lab.model.TicketOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataHolder {
    public static List<Movie> movies = null;
    public static List<TicketOrder> ticketOrders = null;

    public static List<Production> productions = null;


    @PostConstruct
    public void init(){
        productions = new ArrayList<>();
        productions.add(new Production("Hollywood Studios", "United States", "123 Movie St, Los Angeles, CA, USA"));
        productions.add(new Production("Bollywood Films", "India", "456 Bollywood Blvd, Mumbai, India"));
        productions.add(new Production("Tokyo Cinema Co.", "Japan", "789 Cinema Avenue, Tokyo, Japan"));
        productions.add(new Production("Paris Pictures", "France", "321 Film Lane, Paris, France"));
        productions.add(new Production("Sydney Entertainment", "Australia", "555 Entertainment Road, Sydney, Australia"));

        Random rnd = new Random();
        String [] titles = {"The Shawshank Redemption", "The Godfather", "Pulp Fiction", "The Dark Knight", "Schindler's List", "Forrest Gump", "The Matrix", "Inception", "Gladiator", "Titanic"};
        movies = new ArrayList<>();
        for(int i=0; i<10; i++){
            movies.add(new Movie(titles[i], titles[i]+" summary", rnd.nextDouble(10.01), productions.get(rnd.nextInt(0,5))));
        }
        ticketOrders = new ArrayList<>();
    }
}
