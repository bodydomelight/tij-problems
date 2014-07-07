package concurrency.p02;

public class FibonacciTask implements Runnable {

    private final int number;

    public FibonacciTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Fibonacci.printFibonacciNumbers(number);
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new FibonacciTask(10)).start();
        }
    }
}
