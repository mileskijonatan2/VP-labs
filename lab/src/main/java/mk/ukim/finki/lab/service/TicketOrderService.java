package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.TicketOrder;

public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);
}
