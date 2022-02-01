package com.vmware.kafka.practice.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmware.kafka.practice.models.CustomRecord;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class CustomRecordDeserializer implements Deserializer<CustomRecord> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public CustomRecord deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        CustomRecord object = null;
        try {
            object = mapper.readValue(data, CustomRecord.class);
        } catch (Exception exception) {
            System.out.println("Error in deserializing bytes " + exception);
        }
        return object;
    }

    @Override
    public void close() {
    }
}
