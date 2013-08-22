package inner.classes.pkg25;

import inner.classes.pkg24.Event;
import inner.classes.pkg24.GreenhouseControls;

public class GreenhouseControlsNew extends GreenhouseControls {
    private boolean waterMistGenerators = false;
        public class WaterMistGeneratorsOn extends Event { 
            public WaterMistGeneratorsOn(long delayTime) { super(delayTime); } 
                @Override
            public void action() { 
                waterMistGenerators = true; 
            } 
            @Override
            public String toString() { return "Water mist generators is on"; } 
        }
        public class WaterMistGeneratorsOff extends Event { 
            public WaterMistGeneratorsOff(long delayTime) { super(delayTime); } 
                @Override
            public void action() {  
                waterMistGenerators = false; 
            } 
            @Override
            public String toString() { return "Water mist generators is off"; } 
        }
}
