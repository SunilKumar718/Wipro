package UberRide;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class UberProducerController {

    private final KafkaProducerService producerService;

    public UberProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody DTO ride) throws Exception {
        ride.setOperation("CREATE");
        producerService.sendMessage(ride);
        return ResponseEntity.ok("Ride create request sent to Kafka");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody DTO ride) throws Exception {
        ride.setId(id);
        ride.setOperation("UPDATE");
        producerService.sendMessage(ride);
        return ResponseEntity.ok("Ride update request sent to Kafka");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        DTO ride = new DTO();
        ride.setId(id);
        ride.setOperation("DELETE");
        producerService.sendMessage(ride);
        return ResponseEntity.ok("Ride delete request sent to Kafka");
    }
}
