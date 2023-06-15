package trainTicketDemo.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerName;

    @OneToMany(mappedBy = "passenger")
    private Set<Ticket> tickets = new HashSet<>();

    public Passenger() {

    }
    public Passenger(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long passengerId) {
        this.id = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

}
