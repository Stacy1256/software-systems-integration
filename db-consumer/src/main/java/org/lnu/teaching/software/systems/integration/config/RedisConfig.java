package org.lnu.teaching.software.systems.integration.config;

import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.consumer.FacultySubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@AllArgsConstructor
public class RedisConfig {
    private static final String NEW_FACULTY_TOPIC = "NEW_FACULTY_TOPIC";

    private final RedisConnectionFactory redisConnectionFactory;
    private final FacultySubscriber facultySubscriber;

    @Bean
    public RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);

        container.addMessageListener(messageListenerAdapter(), new ChannelTopic(NEW_FACULTY_TOPIC));
        return container;
    }

   private MessageListenerAdapter messageListenerAdapter() {
       MessageListenerAdapter facultyMessageListenerAdapter = new MessageListenerAdapter(facultySubscriber);
       facultyMessageListenerAdapter.afterPropertiesSet();

        return facultyMessageListenerAdapter;
    }
}
