package com.dataengineering.app.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConsumer {

    @KafkaListener(
        topics = "employee-topic",
        groupId = "employee-group"
    )
    public void consume(
        EmployeeEvent event) {
            System.out.println("Consumed Employee Event: " + event.getEmpId() + " " + event.getName());
        }
}
