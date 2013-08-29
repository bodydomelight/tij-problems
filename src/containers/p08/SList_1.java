package containers.p08;

import java.util.NoSuchElementException;

public class SList_1<E> {

    private long listVersion = System.nanoTime(); // for iterators fail-fast ability
    private Link<E> firstLink;

    public SListIterator iterator() {
        return new SListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SListIterator it = iterator();
        sb.append("[");
        while (it.hasNext()) {
            sb.append(it.next()).append(", ");
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");

        return sb.toString();
    }

    private final class SListIterator {

        private long iteratorVersion;
        private Link<E> previousLink;
        private Link<E> beforePreviousLink;  //marker for remove()
        private boolean callToNextRequired = true; //flag for remove()

        private SListIterator() {
            iteratorVersion = listVersion;
        }

        public void remove() {
            checkListConsistency();
            if (callToNextRequired) {
                throw new IllegalStateException("Call to iterator().next() required");
            }
            callToNextRequired = true;
            updateListAndIteratorVersions();
            if (beforePreviousLink == previousLink) { //we are trying to remove first element
                previousLink = null;
                firstLink = firstLink.next;
            } else {
                beforePreviousLink.next = previousLink.next;
                previousLink = beforePreviousLink;
            }

        }

        public void add(E e) {
            checkListConsistency();
            updateListAndIteratorVersions();
            Link<E> newNode = new Link<>(e);
            if (previousLink == null) {
                if (firstLink != null) {
                    newNode.next = firstLink;
                }
                firstLink = newNode;
            } else {
                newNode.next = previousLink.next;
                previousLink.next = newNode;
            }
            previousLink = newNode;
        }

        public boolean hasNext() {
            checkListConsistency();
            if (firstLink == null) {
                return false;
            }
            if (previousLink == null) {
                return true;
            } else {
                return previousLink.next != null;
            }
        }

        public E next() {
            checkListConsistency();
            if (firstLink == null) {
                throw new NoSuchElementException();
            }
            callToNextRequired = false;
            if (previousLink == null) {
                previousLink = firstLink;
                beforePreviousLink = firstLink;
                return previousLink.data;
            }
            if (previousLink.next == null) {
                throw new NoSuchElementException();
            } else {
                beforePreviousLink = previousLink;
                previousLink = previousLink.next;
                return previousLink.data;
            }
        }

        private void checkListConsistency() {
            if (iteratorVersion != listVersion) {
                throw new IllegalStateException("List has been changed after this iterator was created.");
            }
        }

        private void updateListAndIteratorVersions() {
            listVersion++;
            iteratorVersion++;
        }
    }

    private static final class Link<E> {

        private Link<E> next;
        private E data;

        private Link(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data == null ? "null" : data.toString();
        }
    }

    public static void main(String[] args) {
        SList_1<String> slist = new SList_1<>();
        SList_1.SListIterator it = slist.iterator();
        for (int i = 0; i < 10; i++) {
            it.add(i + "");
        }
        System.out.println(slist);
        it = slist.iterator();
        it.next();
        it.remove();
        System.out.println(slist);
        System.out.println(it.next());
        System.out.println(it.next());
        it.remove();
        System.out.println(slist);
        while (it.hasNext()) {
            it.next();
        }
        it.remove();
        System.out.println(slist);
        
        
        // null as an element test
        slist = new SList_1<>();
        it = slist.iterator();
        for (String s : "A B C D E F G H".split(" ")) {
            it.add(s);
        }
        it.add(null);
        System.out.println(slist);
        it = slist.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
            System.out.println(slist);
        }
        
        
        //double remove() call without next() in the middle test
        it = slist.iterator();
        for (String s : "A B C D E F G H".split(" ")) {
            it.add(s);
        }
        it = slist.iterator();
        it.next();
        it.remove();
        try {
            it.remove();
        } catch(IllegalStateException e) {
            System.out.println("IllegalStateException caught");
        }


        //fail-fast test
        slist = new SList_1<>();
        it = slist.iterator();
        it.add("one");
        it.add("two");
        it.add("three");
        System.out.println(slist);
        SList_1.SListIterator it2 = slist.iterator();
        it2.add("four");
        System.out.println(slist);
        try {
            it.add("five");
        } catch (IllegalStateException e) {
            System.out.println("Fail-fast iterator");
        }
    }
}
