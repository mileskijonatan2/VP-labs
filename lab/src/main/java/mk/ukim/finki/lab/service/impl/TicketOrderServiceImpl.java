package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.TicketOrder;
import mk.ukim.finki.lab.repository.TicketOrderRepository;
import mk.ukim.finki.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {
    private final TicketOrderRepository ticketOrderRepository;

    public TicketOrderServiceImpl(TicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        return ticketOrderRepository.addTicketOrder(new TicketOrder(movieTitle, clientName, address, (long)numberOfTickets));
    }
}
