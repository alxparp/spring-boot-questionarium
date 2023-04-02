package com.questionarium.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class Question {

    private final Integer id;
    private final String topic;
    private final String text;

    public Question(@JsonProperty("id") Integer id,
                    @JsonProperty("topic") String topic,
                    @JsonProperty("text") String text) {
        this.id = id;
        this.topic = topic;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }
}