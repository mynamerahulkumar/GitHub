package com.example.cafe.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "multigroup",topics = "multitype")
public class MultiTypeKafkaListener {
    @KafkaHandler
    public void handleGreeting(Welcome welcome){
        System.out.println("Welcome-"+welcome.getMessage()+"-"+welcome.getRemainingMinutes());
    }
    @KafkaHandler
    public void handleFarewell(Farewell farewell){
        System.out.println("Farewell-"+farewell.getMsg()+"-"+farewell.getName());
    }
    @KafkaHandler
    public void unknown(Object object){
        System.out.println("unknown object received-"+object);
    }
}
