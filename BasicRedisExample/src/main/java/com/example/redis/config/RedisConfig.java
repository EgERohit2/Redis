package com.example.redis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {

	
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName("localhost");
		redisStandaloneConfiguration.setPort(6379);
		return new LettuceConnectionFactory(redisStandaloneConfiguration);
	}
	@Bean
	public RedisTemplate<String,Object> redisTemplate(){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
		LettuceConnectionFactory lcf = redisConnectionFactory();
		lcf.afterPropertiesSet();
		template.setConnectionFactory(lcf);
		template.setKeySerializer(stringSerializer);
		template.setHashKeySerializer(stringSerializer);
		template.setValueSerializer(jdkSerializationRedisSerializer);
		template.setHashValueSerializer(jdkSerializationRedisSerializer);
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		return template;

	}
}
