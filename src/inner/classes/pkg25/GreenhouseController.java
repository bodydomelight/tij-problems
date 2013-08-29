package inner.classes.pkg25;

import inner.classes.pkg24.Event;


public class GreenhouseController { 
    public static void main(String[] args) { 
        GreenhouseControlsNew gc = new GreenhouseControlsNew(); 

        gc.addEvent(gc.new Bell(900)); 
        Event[] eventList = { 
            gc.new ThermostatNight(0), 
            gc.new LightOn(200),
            gc.new WaterMistGeneratorsOn(250),
            gc.new FansOn(300),
            gc.new LightOff(400), 
            gc.new WaterOn(600),
            gc.new WaterMistGeneratorsOff(700),
            gc.new WaterOff(800),
            gc.new FansOff(900),
            gc.new ThermostatDay(1400) 
        };   
        gc.addEvent(gc.new Restart(2000, eventList)); 
        if(args.length == 1)
            gc.addEvent( 
                new GreenhouseControlsNew.Terminate( 
                new Integer(args[0]))); 
        gc.run(); 
    } 
}
