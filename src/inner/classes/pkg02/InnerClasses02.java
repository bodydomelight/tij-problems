/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg02;

/**
 *
 * @author aamelin
 */
public class InnerClasses02 { 
  private Object[] items; 
  private int next = 0; 
  public InnerClasses02(int size) { items = new Object[size]; } 
  public void add(Object x) { 
    if(next < items.length) 
      items[next++] = x; 
  } 
  private class SequenceSelector implements Selector { 
    private int i = 0;
    @Override
    public boolean end() { return i == items.length; } 
    @Override
    public Object current() { return items[i]; } 
    @Override
    public void next() { if(i < items.length) i++; } 
  } 
  public Selector selector() { 
    return new SequenceSelector(); 
  }  
  public static void main(String[] args) { 
    final char[] c = {'a', 'b', 'c', 'd', 'e'};
    InnerClasses02 sequence = new InnerClasses02(5);
    
    for (int i = 0; i < 5; i++) {
        sequence.add(c[i]);
    }
    
//    for(int i = 0; i < 10; i++) 
//      sequence.add(Integer.toString(i)); 
    Selector selector = sequence.selector(); 
    while(!selector.end()) { 
      System.out.print(selector.current() + " "); 
      selector.next(); 
    } 
  } 
}