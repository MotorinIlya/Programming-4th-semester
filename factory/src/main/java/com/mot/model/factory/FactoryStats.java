package com.mot.model.factory;

import com.mot.service.Observable;
import com.mot.model.events.Event;

public class FactoryStats extends Observable {

    public enum ELEMENT {
        ACCESSORY,
        BODY,
        MOTOR,
        CAR
    }

    private int accessoryStoredCount = 0;
    private int bodyStoredCount = 0;
    private int motorStoredCount = 0;
    private int carStoredCount = 0;

    private int accessoryProducedCount = 0;
    private int bodyProducedCount = 0;
    private int motorProducedCount = 0;
    private int carProducedCount = 0;

    public synchronized void setStoredCount(ELEMENT el, int value) {
        switch (el) {
            case ACCESSORY:
                accessoryStoredCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_STORED_CNT));
                break;
            case BODY:
                bodyStoredCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_STORED_CNT));
                break;
            case MOTOR:
                motorStoredCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_MOTOR_STORED_CNT));
                break;
            case CAR:
                carStoredCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_STORED_CNT));
                break;
        }

    }

    public synchronized void increaseStoredCount(ELEMENT el) {
        switch (el) {
            case ACCESSORY:
                accessoryStoredCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_STORED_CNT));
                break;
            case BODY:
                bodyStoredCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_STORED_CNT));
                break;
            case MOTOR:
                motorStoredCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_MOTOR_STORED_CNT));
                break;
            case CAR:
                carStoredCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_STORED_CNT));
                break;
        }
    }

    public synchronized void decreaseStoredCount(ELEMENT el) {
        switch (el) {
            case ACCESSORY:
                accessoryStoredCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_STORED_CNT));
                break;
            case BODY:
                bodyStoredCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_STORED_CNT));
                break;
            case MOTOR:
                motorStoredCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_MOTOR_STORED_CNT));
                break;
            case CAR:
                carStoredCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_STORED_CNT));
                break;
        }
    }

    public synchronized void setProducedCount(ELEMENT el, int value) {
        switch (el) {
            case ACCESSORY:
                accessoryProducedCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_PROD_CNT));
                break;
            case BODY:
                bodyProducedCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_PROD_CNT));
                break;
            case MOTOR:
                motorProducedCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_MOTOR_PROD_CNT));
                break;
            case CAR:
                carProducedCount = value;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_PROD_CNT));
                break;
        }
    }

    public synchronized void increaseProducedCount(ELEMENT el) {
        switch (el) {
            case ACCESSORY:
                accessoryProducedCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_PROD_CNT));
                break;
            case BODY:
                bodyProducedCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_PROD_CNT));
                break;
            case MOTOR:
                motorProducedCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_MOTOR_PROD_CNT));
                break;
            case CAR:
                carProducedCount++;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_PROD_CNT));
                break;
        }
    }

    public synchronized void decreaseProducedCount(ELEMENT el) {
        switch (el) {
            case ACCESSORY:
                accessoryProducedCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_ACCESSORY_PROD_CNT));
                break;
            case BODY:
                bodyProducedCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_PROD_CNT));
                break;
            case MOTOR:
                motorProducedCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_BODY_PROD_CNT));
                break;
            case CAR:
                carProducedCount--;
                notifyObservers(new Event(Event.EVENT_TYPE.UPD_CAR_PROD_CNT));
                break;
        }
    }

    public synchronized int getAccessoryStoredCount() {
        return accessoryStoredCount;
    }

    public synchronized int getBodyStoredCount() {
        return bodyStoredCount;
    }

    public synchronized int getMotorStoredCount() {
        return motorStoredCount;
    }

    public synchronized int getCarStoredCount() {
        return carStoredCount;
    }

    public synchronized int getAccessoryProducedCount() {
        return accessoryProducedCount;
    }

    public synchronized int getBodyProducedCount() {
        return bodyProducedCount;
    }

    public synchronized int getMotorProducedCount() {
        return motorProducedCount;
    }

    public synchronized int getCarProducedCount() {
        return carProducedCount;
    }
}
