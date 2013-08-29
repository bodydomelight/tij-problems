package types.p14;

import java.util.*;

class Part {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    static final List<Class<? extends Part>> partFactories =
            new ArrayList<>();

    static {
// Collections.addAll() gives an "unchecked generic
// array creation ... for varargs parameter" warning.
        partFactories.add(new FuelFilter().getClass());
        partFactories.add(new AirFilter().getClass());
        partFactories.add(new CabinAirFilter().getClass());
        partFactories.add(new OilFilter().getClass());
        partFactories.add(new FanBelt().getClass());
        partFactories.add(new PowerSteeringBelt().getClass());
        partFactories.add(new GeneratorBelt().getClass());
    }
    private static Random rand = new Random(47);

    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        Part part = null;
        try {
             part = partFactories.get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getStackTrace());
        }
        return part;
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
}

class AirFilter extends Filter {
}

class CabinAirFilter extends Filter {
}

class OilFilter extends Filter {
}

class Belt extends Part {
}

class FanBelt extends Belt {
}

class GeneratorBelt extends Belt {
}

class PowerSteeringBelt extends Belt {
}

public class RegisteredFactories {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
