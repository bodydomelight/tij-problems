/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers.p10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

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
        System.out.println("comparator01");
        NewSortedSet<String> instance = new NewSortedSet<>();
        Comparator result = instance.comparator();
        assertTrue(result instanceof Comparator);
    }

    /**
     * Test of comparator method, of class NewSortedSet.
     */
    @Test
    public void testComparator02() {
        System.out.println("comparator02");
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
        printResults(expResult, result);
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
        System.out.println("contains");
        Object o = null;
        NewSortedSet instance = new NewSortedSet();
        boolean expResult = false;
        boolean result = instance.contains(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class NewSortedSet.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        NewSortedSet instance = new NewSortedSet();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class NewSortedSet.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        NewSortedSet instance = new NewSortedSet();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class NewSortedSet.
     */
    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        String[] a;
        NewSortedSet instance = new NewSortedSet();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class NewSortedSet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object e = null;
        NewSortedSet instance = new NewSortedSet();
        boolean expResult = false;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class NewSortedSet.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object o = null;
        NewSortedSet instance = new NewSortedSet();
        boolean expResult = false;
        boolean result = instance.remove(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsAll method, of class NewSortedSet.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        Collection<?> c = null;
        NewSortedSet instance = new NewSortedSet();
        boolean expResult = false;
        boolean result = instance.containsAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class NewSortedSet.
     */
    @Ignore("not ready")
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        Collection<? extends E> c = null;
        NewSortedSet instance = new NewSortedSet();
        boolean expResult = false;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class NewSortedSet.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection<?> c = null;
        NewSortedSet instance = new NewSortedSet();
        boolean expResult = false;
        boolean result = instance.retainAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class NewSortedSet.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection<?> c = null;
        NewSortedSet instance = new NewSortedSet();
        boolean expResult = false;
        boolean result = instance.removeAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class NewSortedSet.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        NewSortedSet instance = new NewSortedSet();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private void printResults(Object expResult, Object result) {
        System.out.println("expResult" + expResult);
        System.out.println("result" + result);
    }
}