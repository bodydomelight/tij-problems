package containers.p10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rage
 */
public class NewSortedSetTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of comparator method, of class NewSortedSet.
     */
    @Test
    public void testComparator01() {
        NewSortedSet<String> instance = new NewSortedSet<>();
        Comparator result = instance.comparator();
        assertTrue(result instanceof Comparator);
    }

    /**
     * Test of comparator method, of class NewSortedSet.
     */
    @Test
    public void testComparator02() {
        NewSortedSet<String> instance = new NewSortedSet<>();
        Comparator comparator = instance.comparator();
        assertTrue(comparator.compare("A", "A") == 0);
        assertTrue(comparator.compare("A", "B") < 0);
        assertTrue(comparator.compare("B", "A") > 0);
    }

    /**
     * Test of subSet method, of class NewSortedSet.
     */
    @Test
    public void testSubSet() {
        NewSortedSet<String> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList("A B C D E F G H I J K".split(" ")));
        SortedSet<String> expResult = new TreeSet<>(Arrays.asList("C D E".split(" ")));
        SortedSet<String> result = instance.subSet("C", "F");
        assertEquals(expResult, result);
    }

    @Test
    public void testSubSetEmptySet() {
        NewSortedSet<Object> instance = new NewSortedSet<>();
        SortedSet<Object> result = instance.subSet("C", "F");
        assertTrue(result.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testSubSetNullToElement() {
        NewSortedSet<Object> instance = new NewSortedSet<>();
        instance.subSet("C", null);
    }

    @Test(expected = NullPointerException.class)
    public void testSubSetNullFromElement() {
        NewSortedSet<String> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList("A B C D E F G H I J K".split(" ")));
        instance.subSet(null, "C");
    }

    @Test(expected = NullPointerException.class)
    public void testSubSetNullToAndFromElement() {
        NewSortedSet<String> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList("A B C D E F G H I J K".split(" ")));
        instance.subSet(null, null);
    }

    @Test
    public void testSubSetAbsentElements() {
        NewSortedSet<Object> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList("A B C D E F G H I J K".split(" ")));
        SortedSet<Object> result = instance.subSet("L", "P");
        assertTrue(result.isEmpty());
    }

    /**
     * Test of headSet method, of class NewSortedSet.
     */
    @Test
    public void testHeadSet() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> expResult = new TreeSet(Arrays.asList(1, 2, 3, 4));
        Set<Integer> result = instance.headSet(5);
        assertEquals(expResult, result);
    }

    @Test
    public void testHeadSetEmpty() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        SortedSet<Integer> result = instance.headSet(5);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testHeadSetAbsentElements() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        SortedSet<Integer> result = instance.headSet(11);
        assertTrue(result.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testHeadSetNullElement() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        SortedSet<Integer> result = instance.headSet(null);
        assertTrue(result.isEmpty());
    }

    /**
     * Test of tailSet method, of class NewSortedSet.
     */
    @Test
    public void testTailSet() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> expResult = new TreeSet(Arrays.asList(5, 6, 7, 8, 9));
        Set<Integer> result = instance.tailSet(5);
        assertEquals(expResult, result);
    }

    @Test
    public void testTailSetEmpty() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        SortedSet<Integer> result = instance.tailSet(5);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testTailSetAbsentElements() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        SortedSet<Integer> result = instance.tailSet(11);
        assertTrue(result.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testTailSetNullElement() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        SortedSet<Integer> result = instance.tailSet(null);
        assertTrue(result.isEmpty());
    }

    /**
     * Test of first method, of class NewSortedSet.
     */
    @Test
    public void testFirst() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        for (int i = 0; i < 20; i++) {
            instance.add(i);
        }
        assertEquals(new Integer(0), instance.first());
        assertEquals(20, instance.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testFirstEmpty() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        assertTrue(instance.first() == null);
    }

    /**
     * Test of last method, of class NewSortedSet.
     */
    @Test
    public void testLast() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        for (int i = 1; i <= 20; i++) {
            instance.add(i);
        }
        assertEquals(new Integer(20), instance.last());
        assertEquals(20, instance.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testLastEmpty() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        assertTrue(instance.first() == null);
    }

    /**
     * Test of size method, of class NewSortedSet.
     */
    @Test
    public void testSize() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        assertTrue(instance.size() == 0);
        for (int i = 0; i < 100; i++) {
            instance.add(i);
            assertTrue(instance.size() == i + 1);
        }
        for (int i = 99; i >= 0; i--) {
            instance.remove(i);
            assertTrue(instance.size() == i);
        }
    }

    /**
     * Test of isEmpty method, of class NewSortedSet.
     */
    @Test
    public void testIsEmpty() {
        NewSortedSet<Character> instance = new NewSortedSet<>();
        assertTrue(instance.isEmpty());
        instance.add('X');
        assertFalse(instance.isEmpty());
        instance.remove('X');
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of contains method, of class NewSortedSet.
     */
    @Test
    public void testContains() {
        NewSortedSet<String> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList("A B C D E F G H I J K".split(" ")));
        assertTrue(instance.contains("D"));
        assertFalse(instance.contains("0"));
        instance.add("Z");
        assertTrue(instance.contains("Z"));
        instance.remove("B");
        assertFalse(instance.contains("B"));
    }

    @Test
    public void testContainsNull() {
        NewSortedSet<Object> instance = new NewSortedSet<>();
        assertFalse(instance.contains(null));
        instance.addAll(Arrays.asList("A B C D E F G H I J K".split(" ")));
        assertFalse(instance.contains(null));
    }

    /**
     * Test of iterator method, of class NewSortedSet.
     */
    @Test
    public void testIteratorHasNext() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        Iterator<Integer> it = instance.iterator();
        assertFalse(it.hasNext());
        instance.add(42);
        it = instance.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void testIteratorNext() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        Collections.sort(expResult);
        Iterator<Integer> it = instance.iterator();
        Iterator<Integer> it2 = expResult.iterator();
        while (it.hasNext()) {
            assertTrue(it.next().equals(it2.next()));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextException() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        Iterator<Integer> it = instance.iterator();
        while (true) {
            it.next();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextExceptionEmpty() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        Iterator<Integer> it = instance.iterator();
        it.next();
    }

    @Test
    public void testIteratorRemove() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        Iterator<Integer> it = instance.iterator();
        it.next();
        it.next();
        it.next();
        it.remove();
        assertFalse(instance.contains(11));
    }

    @Test(expected = IllegalStateException.class)
    public void testIteratorRemoveEmpty() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        Iterator<Integer> it = instance.iterator();
        it.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void testIteratorRemoveIllegal() {
        NewSortedSet<Integer> instance = new NewSortedSet();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        Iterator<Integer> it = instance.iterator();
        it.remove();
    }

    /**
     * Test of toArray method, of class NewSortedSet.
     */
    @Test
    public void testToArray() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        Collections.sort(expResult);
        assertArrayEquals(expResult.toArray(), instance.toArray());
    }

    @Test
    public void testToArray0Args() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        assertArrayEquals(new Integer[0], instance.toArray());
    }

    /**
     * Test of toArray method, of class NewSortedSet.
     */
    @Test
    public void testToArray_GenericType() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        Collections.sort(expResult);
        assertArrayEquals(expResult.toArray(new Object[1]), instance.toArray(new Object[0]));
        assertTrue(instance.toArray(new Integer[0]) instanceof Integer[]);
    }

    /**
     * Test of add method, of class NewSortedSet.
     */
    @Test
    public void testAdd() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        for (Integer i : expResult) {
            assertFalse(instance.contains(i));
            assertTrue(instance.add(i));
            assertFalse(instance.add(i));
            assertTrue(instance.contains(i));
        }
        Collections.sort(expResult);
        Iterator<Integer> i1 = instance.iterator();
        Iterator<Integer> i2 = expResult.iterator();
        while (i1.hasNext()) {
            assertTrue(i1.next().equals(i2.next()));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.add(null);
    }

    /**
     * Test of remove method, of class NewSortedSet.
     */
    @Test
    public void testRemove() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        for (Integer i : expResult) {
            assertTrue(instance.contains(i));
            assertTrue(instance.remove(i));
            assertFalse(instance.remove(i));
            assertFalse(instance.contains(i));
        }
    }

    @Test
    public void testRemoveInapropriateType() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        assertFalse(instance.remove(new ArrayList<Object>()));
    }

    /**
     * Test of containsAll method, of class NewSortedSet.
     */
    @Test
    public void testContainsAll() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        assertTrue(instance.containsAll(new ArrayList<>()));
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        assertTrue(instance.containsAll(instance));
        assertTrue(instance.containsAll(new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61))));
        assertTrue(instance.containsAll(new ArrayList<>(Arrays.asList(23, 45, 65))));
        assertTrue(instance.containsAll(new ArrayList<>(Arrays.asList(0))));
        assertFalse(instance.containsAll(new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61, 7))));
        assertFalse(instance.containsAll(new ArrayList<>(Arrays.asList(7))));
    }

    /**
     * Test of addAll method, of class NewSortedSet.
     */
    @Test
    public void testAddAll() {
        NewSortedSet<Float> instance = new NewSortedSet<>();
        Collection<Float> c = Arrays.asList(2.1f, 2.2f, 2.3f, 3.7f, 4.6f);
        instance.addAll(c);
        for (Float f : c) {
            assertTrue(instance.contains(f));
        }
        assertTrue(instance.containsAll(c));
    }

    /**
     * Test of retainAll method, of class NewSortedSet.
     */
    @Test
    public void testRetainAll() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        assertTrue(instance.containsAll(new ArrayList<>()));
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        instance.retainAll(new ArrayList<>(Arrays.asList(65, 0, 17)));
        assertTrue(instance.size() == 2);
        assertTrue(instance.containsAll(new ArrayList<>(Arrays.asList(65, 0))));
    }

    /**
     * Test of removeAll method, of class NewSortedSet.
     */
    @Test
    public void testRemoveAll() {
        NewSortedSet<Integer> instance = new NewSortedSet<>();
        assertTrue(instance.containsAll(new ArrayList<>()));
        List<Integer> expResult = new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        instance.addAll(expResult);
        instance.removeAll(new ArrayList<>(Arrays.asList(65, 0, 17)));
        assertTrue(instance.size() == 8);
        assertTrue(instance.containsAll(new ArrayList<>(Arrays.asList(23, 45, 34, 28, 11, 82, 5, 61))));
    }

    /**
     * Test of clear method, of class NewSortedSet.
     */
    @Test
    public void testClear() {
        NewSortedSet<Integer> instance = new NewSortedSet<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61));
        assertTrue(instance.size() > 0);
        instance.clear();
        assertTrue(instance.isEmpty());
        for (Integer i : new ArrayList<>(Arrays.asList(23, 45, 65, 0, 34, 28, 11, 82, 5, 61))) {
            assertFalse(instance.contains(i));
        }
    }
}