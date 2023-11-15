package mk.ukim.finki.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.service.TicketOrderService;
import org.springframework.web.servlet.tags.HtmlEscapeTag;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ticket-order-servlet", urlPatterns = "/ticketOrder")
public class TicketOrderServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final TicketOrderService ticketOrderService;

    public TicketOrderServlet(SpringTemplateEngine springTemplateEngine, TicketOrderService ticketOrderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.ticketOrderService = ticketOrderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(this.getServletContext()).buildExchange(req, resp);
//        WebContext webContext = new WebContext(webExchange);
//
//        webContext.setVariable("clientName", req.getLocalName());
//        webContext.setVariable("clientIpaddress", req.getRemoteHost());
//        webContext.setVariable("movieTitle", req.getParameter("chosenMovie"));
//
//        webContext.setVariable("numTickets", req.getParameter("numTickets"));
//
//
//        springTemplateEngine.process("orderConfirmation.html", webContext, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(this.getServletContext()).buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        webContext.setVariable("clientName", req.getLocalName());
        webContext.setVariable("clientIpaddress", req.getRemoteHost());
        webContext.setVariable("movieTitle", req.getParameter("chosenMovie"));

        webContext.setVariable("numTickets", req.getParameter("numTickets"));


        springTemplateEngine.process("orderConfirmation.html", webContext, resp.getWriter());
    }
}
