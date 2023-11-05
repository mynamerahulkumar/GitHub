package com.example.cafe.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${message.topic.name}")
    private String topicName;
    @Value(value = "${long.message.topic.name}")
    private String longMsgTopicName;
    @Value(value = "${partitioned.topic.name}")
    private String partionedTopicName;
    @Value(value = "${welcome.topic.name}")
    private String welcomeTopicName;
    @Value(value = "${filtered.topic.name}")
    private String filteredTopicName;
    @Value(value = "${multi.type.topic.name}")
    private String multiTypeTopicName;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String,Object>config=new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        return new KafkaAdmin(config);
    }
    @Bean
    public NewTopic topic1(){
        return new NewTopic(topicName,1,(short) 1);
    }
    @Bean
    public NewTopic topic2(){
        return new NewTopic(partionedTopicName,6,(short) 1);
    }
    @Bean
    public NewTopic topic3(){
        return new NewTopic(filteredTopicName,1,(short) 1);
    }
    @Bean
    public NewTopic topic4(){
        return new NewTopic(welcomeTopicName,1,(short) 1);
    }
    @Bean
    public NewTopic topic5(){
        NewTopic newTopic=new NewTopic(longMsgTopicName,1,(short) 1);
        Map<String,String>config=new HashMap<>();
        config.put("max.message.bytes", "20971520");
        newTopic.configs(config);
        return newTopic;
    }
    @Bean
    public NewTopic multiTypeTopic(){
        return new NewTopic(multiTypeTopicName,1,(short) 1);
    }



}
