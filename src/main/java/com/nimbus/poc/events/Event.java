package com.nimbus.poc.events;

/**
 * Created by Kye on 30/04/15.
 */
public class Event {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "message='" + message + '\'' +
                '}';
    }
}
