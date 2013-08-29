
package holding.p27;

import java.util.Queue;

public class Main {
    public void printQueue(Queue<Command> q) {
        while(q.peek() != null) {
            System.out.println(q.poll().operation());
        }
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        QueueCreator qc = new QueueCreator();
        main.printQueue(qc.getQueue());
    }
}
