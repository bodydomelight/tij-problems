//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
package io.p11;

import io.p11.controller.Event;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreenhouseController {

    private static List<String> readEvents(String path) {
        List<String> eventData = new ArrayList<>();
        try (BufferedReader eventsReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = eventsReader.readLine()) != null) {
                eventData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return eventData;
    }

    private static List<String> readEvents() {
        return readEvents(".\\src\\io\\p11\\events.txt");
    }

    private static Event[] generateEvents(GreenhouseControls gc) {
        List<String> eventsData = readEvents();
        String[] eventData;
        List<Event> events = new ArrayList<>();
        Constructor constructor;

        List<Class<?>> eventClasses = Arrays.asList(GreenhouseControls.class.getClasses());
        Map<String, Class> eventClassesMap = new HashMap<>();
        for (Class cl : eventClasses) {
            eventClassesMap.put(cl.getSimpleName(), cl);
        }

        Class event;
        for (String line : eventsData) {
            eventData = line.split("=");
            try {
                event = eventClassesMap.get(eventData[0]);
                if (event != null) {
                    constructor = event.getConstructor(GreenhouseControls.class, long.class);
                    events.add((Event) (constructor.newInstance(gc,
                            Long.parseLong(eventData[1]))));
                }
            } catch (SecurityException | NoSuchMethodException |
                    InstantiationException | IllegalAccessException |
                    IllegalArgumentException | InvocationTargetException e) {
                System.out.println(e);
                continue;
            }
        }
        return events.toArray(new Event[0]); //force to always create new array
        //with exact length
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();

        Event[] eventList = generateEvents(gc);
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        } else {
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(50000000)));
        }
        gc.run();
    }
} /* Output:
 Bing!
 Thermostat on night setting
 Light is on
 Light is off
 Greenhouse water is on
 Greenhouse water is off
 Thermostat on day setting
 Restarting system
 Terminating
 *///:~
