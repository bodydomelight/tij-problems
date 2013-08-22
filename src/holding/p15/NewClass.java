package holding.p15;

public class NewClass {
    
    
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        char[] c = "+U+n+c-+e+r+t-+a-+i-+n+t+y- +-+r+u-+l+e+s-".toCharArray();
        for(int i = 0; i < c.length; i++) {
            //System.out.println("outside switch " + c[i]);
            switch(c[i]) {
                case '+':   if(i + 1 < c.length && c[i + 1] != '+' && c[i + 1] != '-') {
                                //System.out.println("+ case " + c[i + 1]);
                                stack.push(c[i + 1]);
                                //System.out.println(stack);
                            };
                            break;
                case '-':   
                                //System.out.println("- case " + c[i + 1]);
                                System.out.print(stack.pop());
                            break;
                
            }
        }
    
    }
}
