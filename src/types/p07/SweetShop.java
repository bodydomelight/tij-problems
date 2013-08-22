package types.p07;

import static net.mindview.util.Print.*;

class Candy {

    static {
        print("Loading Candy");
    }

    @Override
    public String toString() {
        return "Candy";
    }
}

class Gum {

    static {
        print("Loading Gum");
    }

    @Override
    public String toString() {
        return "Gum";
    }
}

class Cookie {

    static {
        print("Loading Cookie");
    }

    @Override
    public String toString() {
        return "Cookie";
    }
}

public class SweetShop {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.exit(1);
        } else {
            try {
                for (String className : args) {
                    if (className.equals("p07.Candy")
                            || className.equals("p07.Gum")
                            || className.equals("p07.Cookie")) {
                        Class c = Class.forName(className);
                        try {
                            System.out.println(c.newInstance());
                        } catch (InstantiationException e) {
                            print("Instantiation exception");
                        } catch (IllegalAccessException e) {
                            print("Illegal access exception");
                        }
                    } else {
                        print("Invalid class name");
                    }
                }
            } catch (ClassNotFoundException e) {
                print("Couldn't find Gum");
            }
        }
    }
}
