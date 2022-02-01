package com.kafka.practice.producer;

import com.kafka.practice.constants.Constants;
import com.kafka.practice.serializers.CustomRecordSerializer;
import com.kafka.practice.models.CustomRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerFactory {

    public Producer<Long, String> getDefaultProducer(){
       return this.createDefaultProducer();
    }

    public Producer<Long, CustomRecord> getCustomRecordProducer(){
        return this.createCustomRecordProducer();
    }

    private Producer<Long, String> createDefaultProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_BROKERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, Constants.CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    private Producer<Long, CustomRecord> createCustomRecordProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_BROKERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, Constants.CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomRecordSerializer.class.getName());
        return new KafkaProducer<>(props);
    }
}
