package test;

public class OverrideTest {

    static void print(Base o) {
        System.out.println("Base");
    }

    static void print(Inher o) {
        System.out.println("Inher");
    }

    public static void main(String[] args) {
        print(new Base().getThis());
        print(new Inher().getThis());
        print((Base) new Inher().getThis());

        Inher inher = (Inher)new Inher().getThis();
        print(inher);
    }
}

class Base {
    public Base getThis() {
        return this;
    }
}

class Inher extends Base {
}
