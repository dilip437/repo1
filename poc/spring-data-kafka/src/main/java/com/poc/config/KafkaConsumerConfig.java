package com.poc.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	
	private static final String groupId = "test";
	
	@Bean
	public ConsumerFactory<byte[], byte[]> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", groupId);
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");

	    props.put("key.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
		return new DefaultKafkaConsumerFactory<>(props);
   }
   
   @Bean
   public ConcurrentKafkaListenerContainerFactory<byte[], byte[]> kafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<byte[], byte[]> 
      factory = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      return factory;
   }
}
