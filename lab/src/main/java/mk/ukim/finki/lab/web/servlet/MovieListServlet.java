package mk.ukim.finki.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "movie-list-servlet", urlPatterns = "")
public class MovieListServlet extends HttpServlet {
    private final MovieService movieService;
    private final SpringTemplateEngine springTemplateEngine;

    public MovieListServlet(SpringTemplateEngine springTemplateEngine, MovieService movieService) {
        this.springTemplateEngine = springTemplateEngine;
        this.movieService = movieService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);
        String keywords = (String) req.getParameter("keywords");
        String rating = (String) req.getParameter("rating");
        if(keywords==null||rating==null){
            context.setVariable("movies", movieService.listAll());
        } else{
            context.setVariable("movies", movieService.searchMovies(keywords));
        }

        springTemplateEngine.process(
                "listMovies.html",
                context,
                resp.getWriter()
        );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keywords = (String) req.getParameter("keywords");
        String rating = (String) req.getParameter("rating");
        resp.sendRedirect("/?keywords="+keywords+"&rating="+rating);
    }
}
