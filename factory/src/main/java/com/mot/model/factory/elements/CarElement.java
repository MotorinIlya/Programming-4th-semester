package com.mot.model.factory.elements;

public class CarElement extends Element {
    private final BodyElement body;
    private final MotorElement motor;
    private final AccessoryElement accessory;

    public CarElement(AccessoryElement accessory, BodyElement body, MotorElement motor) {
        super();
        this.accessory = accessory;
        this.body = body;
        this.motor = motor;
    }

    public int getAccessoryID() {
        return accessory.getId();
    }

    public int getBodyID() {
        return body.getId();
    }

    public int getMotorID() {
        return motor.getId();
    }
}
