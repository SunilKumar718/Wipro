package uberRide;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UberService {

    private final UberRepo repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UberService(UberRepo repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${uberride.topic.name}", groupId = "uber_group")
    public void consumeMessage(String message) throws Exception {
        DTO dto = objectMapper.readValue(message, DTO.class);

        switch (dto.getOperation()) {
            case "CREATE":
                UberEntity newRide = new UberEntity();
                newRide.setDriverName(dto.getDriverName());
                newRide.setPassengerName(dto.getPassengerName());
                newRide.setPickupLocation(dto.getPickupLocation());
                newRide.setDropLocation(dto.getDropLocation());
                newRide.setFare(dto.getFare());
                repository.save(newRide);
                System.out.println("Created Ride: " + newRide.getId());
                break;

            case "UPDATE":
                Optional<UberEntity> existingRide = repository.findById(dto.getId());
                if (existingRide.isPresent()) {
                    UberEntity ride = existingRide.get();
                    ride.setDriverName(dto.getDriverName());
                    ride.setPassengerName(dto.getPassengerName());
                    ride.setPickupLocation(dto.getPickupLocation());
                    ride.setDropLocation(dto.getDropLocation());
                    ride.setFare(dto.getFare());
                    repository.save(ride);
                    System.out.println("Updated Ride: " + ride.getId());
                } else {
                    System.out.println("Ride not found for update with ID: " + dto.getId());
                }
                break;

            case "DELETE":
                repository.deleteById(dto.getId());
                System.out.println("Deleted Ride with ID: " + dto.getId());
                break;

            default:
                System.out.println("Unknown operation: " + dto.getOperation());
        }
    }
}
