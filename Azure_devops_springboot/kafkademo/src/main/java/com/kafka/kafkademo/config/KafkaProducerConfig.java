package com.kafka.kafkademo.config;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String PRODUCERS_BROKER;

    @Bean
    public KafkaTemplate<String,Object> kafkaProducerTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    private ProducerFactory<String,Object> producerFactory(){
        Map<String,Object> configProps=new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,PRODUCERS_BROKER);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StdKeySerializers.StringKeySerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }
}
