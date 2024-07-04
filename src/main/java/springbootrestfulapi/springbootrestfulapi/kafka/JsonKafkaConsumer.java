package springbootrestfulapi.springbootrestfulapi.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import springbootrestfulapi.springbootrestfulapi.payload.UserPayload;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consumeJson(UserPayload userPayload) {
        LOGGER.info(String.format("Json message recived -> %s", userPayload.toString()));
    }
}
