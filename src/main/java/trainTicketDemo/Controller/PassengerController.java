package trainTicketDemo.Controller;

import trainTicketDemo.Model.Passenger;
import trainTicketDemo.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/passenger")
@CrossOrigin(origins = "http://localhost:3000")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public ResponseEntity<Set<Passenger>> getAll(){
        return ResponseEntity.ok(passengerService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
        return ResponseEntity.ok(passengerService.save(passenger));
    }

    @PutMapping("/update")
    public ResponseEntity<Passenger> editPassenger(@RequestBody Passenger passenger){
        return ResponseEntity.ok(passengerService.save(passenger));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Passenger> findPassengerById(@PathVariable Long id){
        return ResponseEntity.ok(passengerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void removePassenger(@PathVariable Long id){
        passengerService.remove(id);
    }


}
