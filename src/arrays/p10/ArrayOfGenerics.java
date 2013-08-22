package arrays.p10;

import java.util.*;

public class ArrayOfGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<List<String>> ls;
        ls = new ArrayList<>();
        ls.add(new ArrayList<String>());
// Compile-time checking produces an error:
//! ls[1] = new ArrayList<Integer>();
// The problem: List<String> is a subtype of Object
// Compiles and runs without complaint:
// However, if your needs are straightforward it is
// possible to create an array of generics, albeit
// with an "unchecked" warning:
        List<BerylliumSphere> spheres = new ArrayList<>();
        spheres.addAll(Arrays.asList(new BerylliumSphere(), new BerylliumSphere(),
                new BerylliumSphere()));
    }
}
