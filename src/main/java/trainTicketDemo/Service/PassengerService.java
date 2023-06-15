package trainTicketDemo.Service;

import trainTicketDemo.Model.Passenger;
import trainTicketDemo.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Set<Passenger> findAll(){
        return new HashSet<>(passengerRepository.findAll());
    }

    public Passenger getById(Long id){
        return passengerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Passenger save(Passenger p){
        return passengerRepository.save(p);
    }

    public void remove(Long id){
        passengerRepository.deleteById(id);
    }

}
