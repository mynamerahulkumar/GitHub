package com.kafka.kafkademo.controller;

import com.kafka.kafkademo.model.MessageEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/producer")
@Log4j2
public class ProducerController {

    @Value("${kafka.first-topic}")
    private String FIRST_TOPIC;

    @Autowired
    private KafkaTemplate<String,Object> kafkaProducerTemplate;
    @PostMapping("send")
    public ResponseEntity<?> sendMessage() throws ExecutionException, InterruptedException {
        MessageEntity messageEntity=new MessageEntity("default", LocalDateTime.now());
        CompletableFuture<SendResult<String, Object>> future=kafkaProducerTemplate.send(FIRST_TOPIC,messageEntity);

        // for synchronous result
        SendResult<String,Object>result=future.get();
        log.info("Sent Message with offset :{},partition:{}",result.getRecordMetadata().offset(),result.getRecordMetadata().partition());

        // for aysnchronous call
        future.acceptEitherAsync(new CompletableFuture<SendResult<String,Object>>(){
            @Override
            public void onFailure(Throwable ex){
                log.error("unable to send message {}"+ex.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String,Object> result1){
                log.info("Sent Message with offset :{},partition:{}",result1.getRecordMetadata().offset(),result1.getRecordMetadata().partition());
            }
        });


    }

}
