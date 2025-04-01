package com.smsApp.smsplatform.config;
import com.smsApp.smsplatform.model.Employee;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import java.util.HashMap;
import java.util.Map;
@EnableKafka
@Configuration
public class KafkaConsumerConfig {
//    @Bean
//    public ConsumerFactory<String,String> consumerFactory(){
//        Map<String,Object> config = new HashMap<String,Object>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG,"demo-consumer-group");
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
//        config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class.getName());
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
//        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, StringDeserializer.class.getName());
//        return new DefaultKafkaConsumerFactory<String,String>(config);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory<String,String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }


//    @Bean
//    public ConsumerFactory<String, Employee> empconsumerFactory(){
//        Map<String,Object> config = new HashMap<String,Object>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG,"demo-consumer-group");
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
//        config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class.getName());
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
//        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
//        config.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
//        return new DefaultKafkaConsumerFactory<String,Employee>(config, new StringDeserializer(),
//                new JsonDeserializer<>(Employee.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String,Employee> empkafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory<String,Employee> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(empconsumerFactory());
//        return factory;
//    }

    @Bean
    public ConsumerFactory<String,Employee> consumerFactory2(KafkaProperties kafkaProperties){
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(),new StringDeserializer(),new JsonDeserializer<>(Employee.class));
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,Employee>> kafkaListenerContainerFactory1(KafkaProperties kafkaProperties){
        ConcurrentKafkaListenerContainerFactory<String,Employee> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory2(kafkaProperties));
        return factory;
    }
}
