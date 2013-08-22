package containers.p08;

import java.util.NoSuchElementException;

public class SList<E> {

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
            sb.append(it.next()).append("; ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }

    private final class SListIterator {

        private Link<E> previousLink;

        private SListIterator() {
        }

        public boolean remove() {
            return false;
        }

        public void add(E e) {
            if (previousLink == null) {
                firstLink = previousLink = new Link<>(e);
            } else {
                previousLink.next = new Link<>(e);
                previousLink = previousLink.next;
            }
        }

        public boolean hasNext() {
            if (firstLink == null) {
                return false;
            }
            if (previousLink == null) {
                return firstLink.next != null;
            } else {
                return previousLink.next != null;
            }
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data;
            if (previousLink == null) {
                data = firstLink.data;
                previousLink = firstLink;
            } else {
                data = previousLink.next.data;
                previousLink = previousLink.next;
            }
            return data;
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
            return data != null ? data.toString() : "null";
        }
    }

    public static void main(String[] args) {
        SList<String> sl = new SList<>();
        SList.SListIterator slit = sl.iterator();
        for (int i = 0; i < 10; i++) {
            slit.add(i);
        }
        System.out.println(sl);
    }
}
