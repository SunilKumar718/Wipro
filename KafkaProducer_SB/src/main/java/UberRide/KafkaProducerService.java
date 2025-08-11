package UberRide;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class KafkaProducerService {

    @Value("${uberride.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(DTO dto) throws Exception {
        String jsonMessage = objectMapper.writeValueAsString(dto);

        kafkaTemplate.send(topicName, jsonMessage);
    }
}
