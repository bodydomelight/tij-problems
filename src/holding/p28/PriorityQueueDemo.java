/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holding.p28;

import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author aamelin
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        Random rand = new Random();
        PriorityQueue<Double> pq = new PriorityQueue<Double>();
        for (int i = 0; i < 30; i++) {
            pq.offer(rand.nextDouble());
        }
        while (pq.peek() != null) {
            System.out.print(pq.poll() + ", ");
        }
    }
}
