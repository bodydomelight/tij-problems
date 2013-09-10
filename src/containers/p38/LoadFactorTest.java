package containers.p38;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LoadFactorTest {

    static List<Test<Map<Integer, String>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Map<Integer, String>>("Get random elements") {
            @Override
            int test(Map<Integer, String> container, TestParam tp) {
                Random rand = new Random();
                int loops = tp.loops * 10000;
                for (int i = 0; i < 1000; i++) {
                    container.put(i, i + "");
                }
                for (int i = 0; i < loops; i++) {
                    container.get(rand.nextInt(loops));
                }
                return loops * 2;
            }
        });
    }

    public static void main(String[] args) {
        Tester.run(new HashMap<Integer, String>(1000), tests);
        Tester.run(new HashMap<Integer, String>(1000, 0.8F), tests);
    }
}
