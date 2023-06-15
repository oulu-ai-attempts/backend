package trainTicketDemo.Service;


import trainTicketDemo.Model.Train;
import trainTicketDemo.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TrainService {
    private final TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Set<Train> findAll() {
        return new HashSet<>(trainRepository.findAll());
    }

    public Train getById(String number) {
        return trainRepository.findById(number).orElseThrow(RuntimeException::new);
    }

    public Train save(Train train) {
        return trainRepository.save(train);
    }

    public void remove(String id) {
        trainRepository.deleteById(id);
    }

}
