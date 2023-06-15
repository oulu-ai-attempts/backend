package TrainTicketHuman.Contoller;

import TrainTicketHuman.Controller.TicketController;
import TrainTicketHuman.Model.Passenger;
import TrainTicketHuman.Model.Ticket;
import TrainTicketHuman.Model.Train;
import TrainTicketHuman.Service.TicketService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TicketControllerTest {

}
