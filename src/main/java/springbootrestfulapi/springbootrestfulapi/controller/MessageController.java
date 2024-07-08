package springbootrestfulapi.springbootrestfulapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestfulapi.springbootrestfulapi.kafka.JsonKafkaProducer;
import springbootrestfulapi.springbootrestfulapi.kafka.KafkaProducer;
import springbootrestfulapi.springbootrestfulapi.payload.UserPayload;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJsonMessage (@Valid @RequestBody UserPayload user) {
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        jsonKafkaProducer.sendMessage(user);
        return new ResponseEntity<String>("Json Message sent to the topic", HttpStatus.OK);
    }
}
