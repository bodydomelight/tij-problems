package enums.p05;

import java.util.*;
import static net.mindview.util.Print.*;

public class VowelsAndConsonants {

    enum Letters {

        VOWELS('a', 'e', 'i', 'o', 'u') {
                    @Override
                    public String toString() {
                        return "vowel";
                    }
                },
        SOMETIMES_A_VOWELS('y', 'w') {
                    @Override
                    public String toString() {
                        return "sometimes a vowel";
                    }
                },
        CONSONANTS {
                    @Override
                    public String toString() {
                        return "consonant";
                    }
                };

        private Letters(Character... chars) {
            if (chars != null) {
                this.chars.addAll(Arrays.asList(chars));
            }
        }
        Set<Character> chars = new HashSet<>();

        public static Letters getCategory(char c) {
            if (VOWELS.chars.contains(c)) {
                return VOWELS;
            } else if (SOMETIMES_A_VOWELS.chars.contains(c)) {
                return SOMETIMES_A_VOWELS;
            } else {
                return CONSONANTS;
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            print((char) c + ", " + c + ": " + Letters.getCategory((char) c));
        }
    }
}
