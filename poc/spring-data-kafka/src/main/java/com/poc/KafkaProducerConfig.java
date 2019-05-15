package com.poc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {
	
   @Bean
   public ProducerFactory<byte[], byte[]> producerFactory() {
      Map<String, Object> props = new HashMap<>();
      props.put("bootstrap.servers", "localhost:9092");
      props.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
      props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
      return new DefaultKafkaProducerFactory<>(props);
   }
   
   @Bean
   public KafkaTemplate<byte[], byte[]> kafkaTemplate() {
      return new KafkaTemplate<>(producerFactory());
   }
}
