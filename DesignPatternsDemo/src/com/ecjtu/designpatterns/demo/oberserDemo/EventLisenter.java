package com.ecjtu.designpatterns.demo.oberserDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventLisenter {
    private Map<EventType, Event> eventMap = new HashMap<EventType, Event>();

    /**
     * 添加监听者.
     * @param eventType
     * @param targetObj
     * @param callback
     */
    public void addLisenter(EventType eventType, Object targetObj, Method callback) {
        eventMap.put(eventType, new Event(targetObj, callback));
    }

    public  void trigger(EventType eventType) {
        if (!this.eventMap.containsKey(eventType)) {  return;  }
        Event event  = eventMap.get(eventType);
        try {
            event.getCallback().invoke(event.getDesObj(), event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
