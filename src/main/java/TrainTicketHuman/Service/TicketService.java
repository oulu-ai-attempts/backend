package TrainTicketHuman.Service;

import TrainTicketHuman.Model.Ticket;
import TrainTicketHuman.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    public Ticket getById(Long id){
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public void remove(Long id){
        ticketRepository.deleteById(id);
    }
}
