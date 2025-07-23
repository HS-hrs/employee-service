package HS_hrs.employee_service.Kafka;

import com.example.Dto.EmployeeUserIdSendEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendEmployeeUserIdEvent(Integer userId) {
        try {
            EmployeeUserIdSendEvent event = new EmployeeUserIdSendEvent(userId);
            String message = objectMapper.writeValueAsString(event);
            kafkaTemplate.send("userId", message);
            System.out.println("kafka message" + message);
        } catch (Exception e) {
            throw new RuntimeException("kafka failed", e);
        }
    }
}