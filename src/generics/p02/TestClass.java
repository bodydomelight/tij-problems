/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.p02;

/**
 *
 * @author rage
 */
public class TestClass<T> {
    
    
    public void testThreeObjectHolder(T first, T second, T third, T newFirst,
            T newSecond, T newThird) {
        ThreeObjectsHolder<T> tohString = new ThreeObjectsHolder<>(first , second, third);
        System.out.println("Get first: " + tohString.getFirst());
        System.out.println("Get second: " + tohString.getSecond());
        System.out.println("Get third: " + tohString.getThird());
        tohString.setFirst(newFirst);
        tohString.setSecond(newSecond);
        tohString.setThird(newThird);
        System.out.println("Get new first: " + tohString.getFirst());
        System.out.println("Get new second: " + tohString.getSecond());
        System.out.println("Get new third: " + tohString.getThird());
    }
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.testThreeObjectHolder("1", "2", "3", "new 1", "new 2", "new 3");
        tc.testThreeObjectHolder(true, true, true, false, false, false);
        tc.testThreeObjectHolder('a', 'b', 'c', 'd', 'e', 'f');
    }
}
