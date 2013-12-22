package test;

public class StringReverseRecursion {
    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
        //return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("zalando == " + reverse("zalando") + " : "+ "odnalaz".equals(reverse("zalando")));
    }
}
