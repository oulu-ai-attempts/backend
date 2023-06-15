package TrainTicketHuman.Controller;

import TrainTicketHuman.Model.Train;
import TrainTicketHuman.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/train")
@CrossOrigin(origins = "http://localhost:3000")
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Train>> getAll(){
        return ResponseEntity.ok(trainService.findAll());
    }

    @GetMapping("/{number}")
    public ResponseEntity<Train> findTrainByNumber(@PathVariable String number){
        return ResponseEntity.ok(trainService.getById(number));
    }
    @PutMapping("/update")
    public ResponseEntity<Train> editTrain(@RequestBody Train train){
        return ResponseEntity.ok(trainService.save(train));
    }

    @DeleteMapping("/{number}")
    public void removeTrain(@PathVariable String number){
        trainService.remove(number);
    }

    @PostMapping("/add")
    public ResponseEntity<Train> addTrain(@RequestBody Train train){
        return ResponseEntity.ok(trainService.save(train));
    }
}
