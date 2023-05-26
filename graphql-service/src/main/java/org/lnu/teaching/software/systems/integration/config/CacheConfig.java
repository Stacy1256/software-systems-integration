package org.lnu.teaching.software.systems.integration.config;

import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
@EnableCaching
@AllArgsConstructor
public class CacheConfig {

    private ReactiveRedisConnectionFactory factory;

    @Bean
    public ReactiveRedisTemplate<?, ?> reactiveRedisTemplate() {
        RedisSerializationContext.SerializationPair<Object> jsonSerializer =
                RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
        RedisSerializationContext<Object, Object> serializationContext = RedisSerializationContext
                .newSerializationContext(jsonSerializer)
                .build();

        return new ReactiveRedisTemplate<>(factory, serializationContext);
    }
}
