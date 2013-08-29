/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containers.p11;

import java.util.PriorityQueue;
import java.util.Random;

class CustomClass implements Comparable<CustomClass> {
    private int i;
    public CustomClass() {
        i = new Random().nextInt(101);
                
    }
    public int get() {
        return i;
    }
    @Override
    public int compareTo(CustomClass o) {
        if(o == null)
            throw new NullPointerException("Object is null");
        return this.get() == o.get() ? 0 : (this.get() < o.get() ? -1 : 1);
    }
    @Override
    public String toString() {
        return new Integer(i).toString();
    }
    
}
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<CustomClass> pq = new PriorityQueue<>();
        for (int i = 0; i < 20; i++)
            pq.offer(new CustomClass());
        System.out.println(pq);
        while (pq.peek() != null)
            System.out.print(pq.poll() + ", ");
    }
}
