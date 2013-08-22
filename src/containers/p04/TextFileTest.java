package containers.p04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.mindview.util.TextFile;

public class TextFileTest {

    public static void collectionInitializer(Collection<String> collection, String fileName) {
        collection.addAll(new TextFile(fileName, " "));
        System.out.println(collection.getClass().getSimpleName() + collection);
    }

    public static void main(String[] args) {
        collectionInitializer(new ArrayList(), "d:\\download.txt");
        collectionInitializer(new LinkedList(), "d:\\download.txt");
        collectionInitializer(new HashSet(), "d:\\download.txt");
    }
}
