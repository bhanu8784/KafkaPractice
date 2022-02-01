package com.kafka.practice.models;

public class CustomRecord {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @Override
    public String toString() {
        return "CustomRecord{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
