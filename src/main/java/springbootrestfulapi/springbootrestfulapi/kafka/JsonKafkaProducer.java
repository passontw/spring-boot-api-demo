package springbootrestfulapi.springbootrestfulapi.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import springbootrestfulapi.springbootrestfulapi.dto.UserDto;
import springbootrestfulapi.springbootrestfulapi.payload.UserPayload;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;

    public void sendMessage(UserPayload userPayload) {
        Message<UserPayload> message = MessageBuilder
                .withPayload(userPayload)
                .setHeader(KafkaHeaders.TOPIC, "javaguides")
                .build();

        kafkaTemplate.send(message);
    }
}
