package TrainTicketHuman.Contoller;


import TrainTicketHuman.Controller.TrainController;
import TrainTicketHuman.Model.Train;
import TrainTicketHuman.Service.TrainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TrainControllerTest {
    @Mock
    private TrainService trainService;

    @InjectMocks
    private TrainController trainController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_shouldReturnAllTrains() {
        Set<Train> trains = new HashSet<>();
        trains.add(new Train());
        when(trainService.findAll()).thenReturn(trains);

        ResponseEntity<Set<Train>> response = trainController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trains, response.getBody());
    }

    @Test
    void findTrainByNumber_existingTrain_shouldReturnTrain() {
        String trainNumber = "123";
        Train train = new Train();
        when(trainService.getById(trainNumber)).thenReturn(train);

        ResponseEntity<Train> response = trainController.findTrainByNumber(trainNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(train, response.getBody());
    }

    @Test
    void editTrain_shouldReturnEditedTrain() {
        Train train = new Train();
        when(trainService.save(train)).thenReturn(train);

        ResponseEntity<Train> response = trainController.editTrain(train);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(train, response.getBody());
    }

    @Test
    void removeTrain_shouldCallTrainServiceRemove() {
        String trainNumber = "123";

        trainController.removeTrain(trainNumber);

        verify(trainService, times(1)).remove(trainNumber);
    }

    @Test
    void addTrain_shouldReturnAddedTrain() {
        Train train = new Train();
        when(trainService.save(train)).thenReturn(train);

        ResponseEntity<Train> response = trainController.addTrain(train);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(train, response.getBody());
    }
}

