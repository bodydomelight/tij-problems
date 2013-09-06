package containers.p32;

import containers.p29.*;

public abstract class Test<C> {

    String name;

    public Test(String name) {
        this.name = name;
    }
// Override this method for different tests.
// Returns actual number of repetitions of test.
    abstract int test(C container, TestParam tp);
}
