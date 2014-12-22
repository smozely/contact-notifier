package com.smozely.si.clock;

import java.time.Clock;
import java.time.Instant;

public class ClockHolder {

    private static Clock clock = Clock.systemDefaultZone();

    public static Clock getClock() {
        return clock;
    }

    public static void setClock(Clock clock) {
        ClockHolder.clock = clock;
    }

    public static Instant now() {
        return Instant.now(clock);
    }

}
