package com.vmware.kafka.practice;

import com.vmware.kafka.practice.constants.Constants;
import com.vmware.kafka.practice.models.CustomRecord;
import com.vmware.kafka.practice.producer.ProducerFactory;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class ProducerApp {
    public static void main(String[] args) {

       // runProducer();
        runCustomRecordProducer();
    }
    static void runProducer() {
        Producer<Long, String> producer = new ProducerFactory().getDefaultProducer();

        for (int index = 0; index < Constants.MESSAGE_COUNT; index++) {
            final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(Constants.TOPIC_NAME,
                    "This is record " + index);
            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            } catch (ExecutionException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            } catch (InterruptedException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
        }
    }
    static void runCustomRecordProducer() {
        Producer<Long, CustomRecord> producer = new ProducerFactory().getCustomRecordProducer();
        CustomRecord record1 = new CustomRecord();
        record1.setName("bhanu");
        record1.setId("101");
            final ProducerRecord<Long, CustomRecord> record = new ProducerRecord<Long, CustomRecord>(Constants.TOPIC_NAME,
                    record1);
            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + record1 + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            } catch (ExecutionException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            } catch (InterruptedException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
    }
}
