package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

@Repository
public class TicketOrderRepository {
    public TicketOrder addTicketOrder(TicketOrder ticketOrder){
        DataHolder.ticketOrders.add(ticketOrder);
        return ticketOrder;
    }
}
