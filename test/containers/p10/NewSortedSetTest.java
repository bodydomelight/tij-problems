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

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

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
    public void testComparator() {
        System.out.println("comparator");
        NewSortedSet instance = new NewSortedSet();
        Comparator expResult = null;
        Comparator result = instance.comparator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subSet method, of class NewSortedSet.
     */
    @Test
    public void testSubSet() {
        System.out.println("subSet");
        NewSortedSet<String> instance = new NewSortedSet<>();
        instance.addAll(Arrays.asList("A B C D E F G H I J K".split(" ")));
        SortedSet<String> expResult = new TreeSet<>(Arrays.asList("C D E".split(" ")));
        SortedSet<String> result = instance.subSet("C", "F");
        System.out.println("expResult:" + expResult);
        System.out.println("instance:" + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of headSet method, of class NewSortedSet.
     */
    @Test
    public void testHeadSet() {
        System.out.println("headSet");
        Object toElement = null;
        NewSortedSet instance = new NewSortedSet();
        SortedSet expResult = null;
        SortedSet result = instance.headSet(toElement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tailSet method, of class NewSortedSet.
     */
    @Test
    public void testTailSet() {
        System.out.println("tailSet");
        Object fromElement = null;
        NewSortedSet instance = new NewSortedSet();
        SortedSet expResult = null;
        SortedSet result = instance.tailSet(fromElement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of first method, of class NewSortedSet.
     */
    @Test
    public void testFirst() {
        System.out.println("first");
        NewSortedSet instance = new NewSortedSet();
        Object expResult = null;
        Object result = instance.first();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of last method, of class NewSortedSet.
     */
    @Test
    public void testLast() {
        System.out.println("last");
        NewSortedSet instance = new NewSortedSet();
        Object expResult = null;
        Object result = instance.last();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class NewSortedSet.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        NewSortedSet instance = new NewSortedSet();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class NewSortedSet.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        NewSortedSet instance = new NewSortedSet();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    @Ignore("not ready")
    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        T[] a = null;
        NewSortedSet instance = new NewSortedSet();
        Object[] expResult = null;
        Object[] result = instance.toArray(a);
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
}