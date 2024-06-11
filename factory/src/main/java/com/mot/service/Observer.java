package com.mot.service;

import com.mot.model.events.Event;

public interface Observer {
    public void update(Event event);
}
