package springbootrestfulapi.springbootrestfulapi.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@Configurable
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaguidesTopic () {
        return TopicBuilder.name("javaguides")
                .partitions(10)
                .build();
    }
}
