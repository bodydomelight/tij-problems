package error.p30;

class Annoyance extends RuntimeException {
}

class Sneeze extends Annoyance {
}

public class Human {

    public void throwException(int i) {
        try {
            switch (i) {
                case 0:
                    throw new Sneeze();
                case 1:
                    throw new Annoyance();
                default:
                    return;
            }
        } catch (RuntimeException re) {
            throw new RuntimeException(re);
        }
    }

    public static void main(String[] args) {

        Human human = new Human();

        for (int i = 0; i < 4; i++) {
            try {
                human.throwException(i);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (Sneeze e) {
                    System.out.println("sneeze " + e);
                } catch (Annoyance e) {
                    System.out.println("annoyance " + e);
                } catch (Throwable e) {
                    System.out.println("runtime exception " + e);
                    e.printStackTrace();
                }
            }
        }
    }
}
