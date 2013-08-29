package error.p25;

class ExA extends Exception {
}

class ExB extends ExA {
}

class ExC extends ExB {
}

class A {

    public void throwException() throws ExA {
        throw new ExA();
    }
}

class B extends A {

    @Override
    public void throwException() throws ExB {
        throw new ExB();
    }
}

class C extends B {

    @Override
    public void throwException() throws ExC {
        throw new ExC();
    }
}

public class ThreeLevelException {

    public static void main(String[] args) {
        A a = new C();
//        System.out.println("p25");
        try {
//            System.out.println("Before exception");
            a.throwException();
//            System.out.println("After exception");
        } catch (ExC e) {
            System.out.println("C");
        } catch (ExB e) {
            System.out.println("B");
        } catch (ExA e) {
            System.out.println("A");
        }
    }
}
