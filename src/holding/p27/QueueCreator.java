package holding.p27;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCreator {
    private Queue<Command> q = new LinkedList<Command>();
    
    public Queue<Command> getQueue() {
        q.add(new Command("first"));
        q.add(new Command("second"));
        q.add(new Command("third"));
        q.add(new Command("fourth"));
        q.add(new Command("fifth"));
        return q;
    }
}
