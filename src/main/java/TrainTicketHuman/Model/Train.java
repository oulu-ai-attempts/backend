package TrainTicketHuman.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Train {

    @Id
    private String trainNumber;
    private String sourceStation;
    private String destinationStation;

    public Train(){

    }

    @OneToMany(mappedBy = "train")
    private Set<Ticket> tickets = new HashSet<>();
    public Train(String trainNumber, String sourceStation, String destinationStation) {
        this.trainNumber = trainNumber;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

}
