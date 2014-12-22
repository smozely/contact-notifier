package com.smozely.si.json;

import java.time.Instant;

import static com.smozely.si.clock.ClockHolder.now;

public class Response {

    private final String status;

    private final Instant timestamp;

    private Response(String status, Instant timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }

    public static Response OK() {
        return new Response("OK", now());
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

}
