package holding.p04;

import java.util.*;

class Generator {
    private String[] namePool = {"First Name", "Second Name", "Third Name"};
    private int i = 0;
    public String next() {
        if (!(i < namePool.length))
            i = 0;
        return namePool[i++];
    }
}

public class GeneratorImpl {
    private static Collection<String> list;
    public static Collection<String> fillList (Collection<String> list) {
        Generator generator = new Generator();
        for (int i = 0; i < 10; i++) {
            list.add(generator.next());
        }
        return GeneratorImpl.list = list;
    }
    public static void printList(Collection<String> list, String message) {
        System.out.println(message);
        System.out.println(list);
    }
    
    public static void main(String[] args) {

        fillList(new ArrayList<String>());
        printList(list, "ArrayList:");

        fillList(new LinkedList<String>());
        printList(list, "LinkedList:");

        fillList(new HashSet<String>());
        printList(list, "HashSet:");

        fillList(new LinkedHashSet<String>());
        printList(list, "LinkedHashSet:");

        fillList(new TreeSet<String>());
        printList(list, "TreeSet:");
    }
}
