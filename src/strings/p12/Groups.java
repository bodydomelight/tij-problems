package strings.p12;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.*;

public class Groups {

    static public final String POEM =
            "Twas brillig, and the slithy toves\n"
            + "Did gyre and gimble in the wabe.\n"
            + "All mimsy were the borogoves,\n"
            + "And the mome raths outgrabe.\n\n"
            + "Beware the Jabberwock, my son,\n"
            + "The jaws that bite, the claws that catch.\n"
            + "Beware the Jubjub bird, and shun\n"
            + "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>();
        Matcher m = Pattern.compile("\\b[a-z]+").matcher(POEM);
        while (m.find()) {
            set.add(m.group());
        }
        System.out.println("The number of unique words which don't start"
                + " with capital letter is: " + set.size() + "\n" + 
                "These words are: " + set);
    }
}