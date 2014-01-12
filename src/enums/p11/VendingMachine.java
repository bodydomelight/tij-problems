package enums.p11;

import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class VendingMachine {

    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;
    private final static HashMap<Input, Category> categories = new HashMap<>();

    enum StateDuration {

        TRANSIENT
    } // Tagging enum

    enum State {

        RESTING {
                    @Override
                    void next(Input input) {
                        switch (categories.get(input)) {
                            case MONEY:
                                amount += input.amount();
                                state = ADDING_MONEY;
                                break;
                            case SHUT_DOWN:
                                state = TERMINAL;
                            default:
                        }
                    }
                },
        ADDING_MONEY {
                    @Override
                    void next(Input input) {
                        switch (categories.get(input)) {
                            case MONEY:
                                amount += input.amount();
                                break;
                            case ITEM_SELECTION:
                                selection = input;
                                if (amount < selection.amount()) {
                                    print("Insufficient money for " + selection);
                                } else {
                                    state = DISPENSING;
                                }
                                break;
                            case QUIT_TRANSACTION:
                                state = GIVING_CHANGE;
                                break;
                            case SHUT_DOWN:
                                state = TERMINAL;
                            default:
                        }
                    }
                },
        DISPENSING(StateDuration.TRANSIENT) {
                    @Override
                    void next() {
                        print("here is your " + selection);
                        amount -= selection.amount();
                        state = GIVING_CHANGE;
                    }
                },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
                    @Override
                    void next() {
                        if (amount > 0) {
                            print("Your change: " + amount
                            );
                            amount = 0;
                        }
                        state = RESTING;
                    }
                },
        TERMINAL {
                    @Override
                    void output() {
                        print("Halted");
                    }
                };
        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("Only call "
                    + "next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for "
                    + "StateDuration.TRANSIENT states");
        }

        void output() {
            print(amount);
        }
    }

    // filling in the categories map
    static {
        ArrayList<String> availableItems
                = new TextFile(".\\src\\enums\\p11\\AvailableObjects", ";");
        for (String className : availableItems) {
                try {
                    Input input = (Input) Class.
                            forName("enums.p11." + className.trim()).newInstance();
                    categories.put(input, input.category());
                } catch (ClassNotFoundException | InstantiationException |
                        IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }

    static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new FileInputGenerator();
        run(gen);
    }
}

// Create Inputs from a file of ‘;’-separated strings:
class FileInputGenerator implements Generator<Input> {

    private final Iterator<String> input;

    public FileInputGenerator() {
        input = new TextFile(".\\src\\enums\\p11\\TestInstructions", ";")
                .iterator();
    }

    @Override
    public Input next() {
        if (!input.hasNext()) {
            return null;
        }
        try {
            return (Input) Class.forName("enums.p11." + input.next().trim()).newInstance();
        } catch (ClassNotFoundException |
                IllegalAccessException | InstantiationException ex) {
            throw new RuntimeException(ex);
        }

    }
}
