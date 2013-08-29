/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holding.p29;

import java.util.PriorityQueue;

/**
 *
 * @author aamelin
 */
public class NewClass {
    public static void main(String[] args) {
        PriorityQueue<NewClass> pq = new PriorityQueue<NewClass>();
        pq.offer(new NewClass());
        pq.offer(new NewClass());
    }
}
