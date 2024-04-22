package com.mot.service;

import com.mot.event.Event;

public interface Observer {
    public void update(Event event);
}
