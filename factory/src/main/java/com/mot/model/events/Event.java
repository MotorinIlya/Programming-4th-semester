package com.mot.model.events;

public class Event {
    public enum EVENT_TYPE {
        UPD_ACCESSORY_STORED_CNT,
        UPD_BODY_STORED_CNT,
        UPD_MOTOR_STORED_CNT,
        UPD_CAR_STORED_CNT,
        UPD_ACCESSORY_PROD_CNT,
        UPD_BODY_PROD_CNT,
        UPD_MOTOR_PROD_CNT,
        UPD_CAR_PROD_CNT,
    }

    private final EVENT_TYPE eventType;

    public Event(EVENT_TYPE eventType) {
        this.eventType = eventType;
    }

    public EVENT_TYPE getEventType() {
        return eventType;
    }
}
