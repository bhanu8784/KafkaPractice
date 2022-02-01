package com.kafka.practice.consumer;

import com.kafka.practice.constants.Constants;
import com.kafka.practice.models.CustomRecord;
import com.kafka.practice.serializers.CustomRecordDeserializer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class ConsumerFactory {

    public Consumer<Long, String> getDefaultConsumer(){
        return this.createConsumer();
    }
    private Consumer<Long, String> createConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_BROKERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, Constants.GROUP_ID_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, Constants.MAX_POLL_RECORDS);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Constants.OFFSET_RESET_EARLIER);

        final Consumer<Long, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(Constants.TOPIC_NAME));
        return consumer;
    }

    public Consumer<Long, CustomRecord> getCustomRecordConsumer(){
        return this.createCustomRecordConsumer();
    }
    private Consumer<Long, CustomRecord> createCustomRecordConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_BROKERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, Constants.GROUP_ID_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomRecordDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, Constants.MAX_POLL_RECORDS);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Constants.OFFSET_RESET_EARLIER);

        final Consumer<Long, CustomRecord> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(Constants.TOPIC_NAME));
        return consumer;
    }
}
