package com.smozely.si.json;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;

import static com.smozely.si.clock.ClockHolder.now;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private final String status;

    private final Instant timestamp;

    private final String message;

    private Response(String status, Instant timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

    public static Response OK(String message) {
        return new Response("OK", now(), message);
    }

    public static Response OK() {
        return OK(null);
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
