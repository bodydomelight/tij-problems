package holding.p06;

//import typeinfo.pets.*; 
import java.util.*; 
//import static net.mindview.util.Print.*; 
 
public class ListFeatures {
    public static void print(Object o) {
        System.out.println(o);
    }
    public static String[] getStringArray(int j) {
        String[] strArray = new String[j];
        for (int i = 0; i < j; i++) {
            strArray[i] = ListFeatures.stringArray[rand.nextInt(4)];
        }
        return strArray;
    }
    static Random rand = new Random(47);
    static String[] stringArray = {"first", "second", "third", "fourth", "fifth"};
    
  public static void main(String[] args) { 
    
    List<String> ints = new LinkedList<String>();
    Collections.addAll(ints, getStringArray(7));
    print("1: " + ints); 
    String h = "string"; 
    ints.add(h); // Automatically resizes 
    print("2: " + ints); 
    print("3: " + ints.contains(h)); 
    ints.remove(h); // Remove by object 
    String p = ints.get(2); 
    print("4: " +  p + " " + ints.indexOf(p)); 
    String cymric = "cymric"; 
    print("5: " + ints.indexOf(cymric)); 
    print("6: " + ints.remove(cymric)); 
    // Must be the exact object: 
    print("7: " + ints.remove(p)); 
    print("8: " + ints); 
    ints.add(3, "thirty five"); // Insert at an index 
    print("9: " + ints); 
    List<String> sub = ints.subList(1, 4); 
    print("subList: " + sub); 
    print("10: " + ints.containsAll(sub)); 
    Collections.sort(sub); // In-place sort 
    print("sorted subList: " + sub); 
    // Order is not important in containsAll(): 
    print("11: " + ints.containsAll(sub)); 
    Collections.shuffle(sub, rand); // Mix it up 
    print("shuffled subList: " + sub); 
    print("12: " + ints.containsAll(sub)); 
    List<String> copy = new ArrayList<String>(ints); 
    sub = Arrays.asList(ints.get(1), ints.get(4)); 
    print("sub: " + sub); 
    copy.retainAll(sub); 
    print("13: " + copy); 
    copy = new ArrayList<String>(ints); // Get a fresh copy 
    copy.remove(2); // Remove by index 
    print("14: " + copy); 
    copy.removeAll(sub); // Only removes exact objects 
    print("15: " + copy); 
    copy.set(1, "six"); // Replace an element 
    print("16: " + copy); 
    copy.addAll(2, sub); // Insert a list in the middle 
    print("17: " + copy); 
    print("18: " + ints.isEmpty()); 
    ints.clear(); // Remove all elements 
    print("19: " + ints); 
    print("20: " + ints.isEmpty()); 
    Collections.addAll(ints, getStringArray(4)); 
    print("21: " + ints); 
    Object[] o = ints.toArray(); 
    print("22: " + o[3]); 
    String[] pa = ints.toArray(new String[0]); 
    print("23: " + pa[3]); 
  }
}
