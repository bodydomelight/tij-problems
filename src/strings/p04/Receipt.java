package strings.p04;

import java.util.*;

public class Receipt {

    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private int widthFirstColumn, widthSecondColumn, widthThirdColumn;
    
    Receipt(int a, int b, int c) {
        widthFirstColumn = a;
        widthSecondColumn = b;
        widthThirdColumn = c;
    }
    
    public void printTitle() {
        f.format("%" + widthFirstColumn + "s %" + widthSecondColumn + "s %" + widthThirdColumn + "s\n", "Item", "Qty", "Price");
        f.format("%" + widthFirstColumn + "s %" + widthSecondColumn + "s %" + widthThirdColumn + "s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%" + widthFirstColumn + ".15s %" + widthSecondColumn + "d %" + widthThirdColumn + ".2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%" + widthFirstColumn + "s %" + widthSecondColumn + "s %" + widthThirdColumn + ".2f\n", "Tax", "", total * 0.06);
        f.format("%" + widthFirstColumn + "s %" + widthSecondColumn + "s %" + widthThirdColumn + "s\n", "", "", "-----");
        f.format("%" + widthFirstColumn + "s %" + widthSecondColumn + "s %" + widthThirdColumn + ".2f\n", "Total", "",
                total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt(-15, 5, 10);
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
