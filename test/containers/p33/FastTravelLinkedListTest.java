package containers.p33;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//import containers.p33.FastTravelLinkedList;

@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class FastTravelLinkedListTest {

    FastTravelLinkedList<String> f;
    Iterator<String> it;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        f = new FastTravelLinkedList<>();
        for (int i = 0; i < 10; i++) {
            f.add(i + "");
        }
    }

    @After
    public void tearDown() throws Exception {
        f = null;
        it = null;
    }
}