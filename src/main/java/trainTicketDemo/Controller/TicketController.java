package trainTicketDemo.Controller;

import trainTicketDemo.Model.Ticket;
import trainTicketDemo.Service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAll(){
        return ResponseEntity.ok(ticketService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findTicketById(@PathVariable Long id){
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Ticket> editTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok(ticketService.save(ticket));
    }

    @DeleteMapping("/{id}")
    public void removeTicket(@PathVariable Long id){
        ticketService.remove(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok(ticketService.save(ticket));
    }
}
