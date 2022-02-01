package com.kafka.practice;

import com.kafka.practice.constants.Constants;
import com.kafka.practice.consumer.ConsumerFactory;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class ConsumerApp {
    public static void main(String[] args) {
        runConsumer();
    }

    static void runConsumer() {
        Consumer<Long, String> consumer = new ConsumerFactory().getDefaultConsumer();

        int noMessageToFetch = 0;

        while (true) {
            final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
            if (consumerRecords.count() == 0) {
                noMessageToFetch++;
                if (noMessageToFetch > Constants.MAX_NO_MESSAGE_FOUND_COUNT)
                    break;
                else
                    continue;
            }

            consumerRecords.forEach(record -> {
                System.out.println("Record Key " + record.key());
                System.out.println("Record value " + record.value());
                System.out.println("Record partition " + record.partition());
                System.out.println("Record offset " + record.offset());
            });
            consumer.commitAsync();
        }
        consumer.close();
    }
}
