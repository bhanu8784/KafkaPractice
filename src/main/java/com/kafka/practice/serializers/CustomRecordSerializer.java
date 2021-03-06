package com.kafka.practice.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.practice.models.CustomRecord;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomRecordSerializer implements Serializer<CustomRecord> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, CustomRecord data) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception exception) {
            System.out.println("Error in serializing object" + data);
        }
        return retVal;
    }

    @Override
    public void close() {

    }
}
