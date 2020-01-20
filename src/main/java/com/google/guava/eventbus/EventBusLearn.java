package com.google.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * fundamental concept is that:
 * we have a eventbus, where we can do 2 things mainly
 * in that eventbus, we can publish events
 * with that eventbus, we can subscribe for events (in other words: register for events) ,
 * thereby we can also unsubscribe for events
 */
public class EventBusLearn {

    static EventBus eventBus = new EventBus();

    public static void main(String[] args) {
        // create event object ( in our case, to simplify, event is just a string object
        String eventObject = new String("event string");

        // create event listener
        EventListener eventListener = new EventListener();
        // register event listener with event bus
        eventBus.register(eventListener);
        // post event object to eventbus
        eventBus.post(eventObject);
        // assert that listener got invoked
        System.out.println(eventListener.getEventCount() > 0 );

    }

    static class EventListener{
        // we will use @Subscribe annotation to subscribe to specific events

        int eventCount = 0;

        @Subscribe
        public void onStringEvent(String eventString){
            System.out.println("Listener has received event :"+ eventString);
            eventCount++;
        }

        public int getEventCount(){
            return eventCount;
        }



    }

}
