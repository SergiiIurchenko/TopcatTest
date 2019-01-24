package com.ubs.opsit.interviews.time.container;

import java.util.concurrent.TimeUnit;

/**
 * Generic time which returns separate time units
 */
public interface TimeContainer {
    int get(TimeUnit timeUnit);
}
