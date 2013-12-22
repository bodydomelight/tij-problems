package test;

public class Cross {
    static int cross(int h) {
        int center = h/2;
        for (int i = 0; i < center; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 2; j < h - 2*i; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < center; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
        for (int i = 1; i <= center; i++) {
            for (int j = 0; j < center - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 1; j < i*2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        return 0;
    }
    public static void main(String[] args) {
        cross(13);
    }
}
