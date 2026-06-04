package com.dataengineering.app.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProducer {
    
    private final KafkaTemplate<String, EmployeeEvent> kafkaTemplate;

    public EmployeeProducer(KafkaTemplate<String, EmployeeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(EmployeeEvent event) {
        kafkaTemplate.send("employee-topic", event);
    }

}
