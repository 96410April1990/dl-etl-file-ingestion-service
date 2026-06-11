package com.dataengineering.app.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaConfig {

    @Bean
    public NewTopic employeeTopic() {
        return TopicBuilder
                .name("employee-topic")
                .build();
    }

    @Bean
    public NewTopic employeeDlqTopic() {
        return TopicBuilder
                .name("employee-dlq-topic")
                .build();
    }
    
}
