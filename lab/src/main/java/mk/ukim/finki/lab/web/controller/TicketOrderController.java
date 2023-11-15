package mk.ukim.finki.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.lab.repository.TicketOrderRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;

@Controller
@RequestMapping("/ticket-order")
public class TicketOrderController {
    private final TicketOrderRepository ticketOrderRepository;

    public TicketOrderController(TicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    @PostMapping("/showOrderConfirmation")
    public String showOrderConfirmation(HttpServletRequest req, @RequestParam String chosenMovie, @RequestParam String numTickets, Model model){
//        webContext.setVariable("clientName", req.getLocalName());
//        webContext.setVariable("clientIpaddress", req.getRemoteHost());
//        webContext.setVariable("movieTitle", req.getParameter("chosenMovie"));
//
//        webContext.setVariable("numTickets", req.getParameter("numTickets"));
        model.addAttribute("clientName", req.getLocalName());
        model.addAttribute("clientIpaddress", req.getRemoteHost());
        model.addAttribute("movieTitle", chosenMovie);
        model.addAttribute("numTickets", numTickets);
        return "orderConfirmation";
    }
}
