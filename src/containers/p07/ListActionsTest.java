package containers.p07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import net.mindview.util.Countries;

public class ListActionsTest {

    public static <T> void printList(List<T> list) {
        //Iterator<String> iterator = list.iterator();
        for (T element : list) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    public static <T> void insertEveryOtherLocation(List<T> resultingList, List<T> argsList) {
        ListIterator<T> itResult = resultingList.listIterator();
        ListIterator<T> itArgs = argsList.listIterator();
        while (itArgs.hasNext()) {
            itResult.add(itArgs.next());
            if (itResult.hasNext()) {
                itResult.next();
            }
        }

    }

    public static <T> void insertEveryOtherLocationBackward(List<T> resultingList, List<T> argsList) {
        ListIterator<T> itResult = resultingList.listIterator(resultingList.size());
        ListIterator<T> itArgs = argsList.listIterator();
        while (itArgs.hasNext()) {
            itResult.add(itArgs.next());
            itResult.previous();
            if (itResult.hasPrevious()) {
                itResult.previous();
            }
        }
    }

    public static void main(String[] args) {
        int aListSize = 5;
        int lListSize = 3;
        List<String> arrayList = new ArrayList<>(Countries.names(aListSize));
        List<String> linkedList = new LinkedList<>(Countries.names(lListSize));
        System.out.println("Arrays");
        printList(arrayList);
        printList(linkedList);

        System.out.println("\ninsertEveryOtherLocation");
        insertEveryOtherLocation(arrayList, linkedList);
        printList(arrayList);
        printList(linkedList);

        System.out.println("\ninsertEveryOtherLocationBackward");
        arrayList = new ArrayList<>(Countries.names(aListSize));
        linkedList = new LinkedList<>(Countries.names(lListSize));

        insertEveryOtherLocationBackward(arrayList, linkedList);
        printList(arrayList);
        printList(linkedList);
    }
}
