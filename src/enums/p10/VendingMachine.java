package enums.p10;

import java.util.*;
import net.mindview.util.*;
import static enums.p10.Input.*;
import static net.mindview.util.Print.*;

enum Category {

    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;

    Category(Input... types) {
        values = types;
    }
    private static EnumMap<Input, Category> categories
            = new EnumMap<>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input type : c.values) {
                categories.put(type, c);
            }
        }
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}

public class VendingMachine {

    private State state = State.RESTING;
    private int amount = 0;
    private Input selection = null;

    enum StateDuration {

        TRANSIENT
    } // Tagging enum

    enum State {

        RESTING {
                    @Override
                    void next(VendingMachine vm, Input input) {
                        switch (Category.categorize(input)) {
                            case MONEY:
                                vm.amount += input.amount();
                                vm.state = ADDING_MONEY;
                                break;
                            case SHUT_DOWN:
                                vm.state = TERMINAL;
                            default:
                        }
                    }
                },
        ADDING_MONEY {
                    @Override
                    void next(VendingMachine vm, Input input) {
                        switch (Category.categorize(input)) {
                            case MONEY:
                                vm.amount += input.amount();
                                break;
                            case ITEM_SELECTION:
                                vm.selection = input;
                                if (vm.amount < vm.selection.amount()) {
                                    print("Insufficient money for " + vm.selection);
                                } else {
                                    vm.state = DISPENSING;
                                }
                                break;
                            case QUIT_TRANSACTION:
                                vm.state = GIVING_CHANGE;
                                break;
                            case SHUT_DOWN:
                                vm.state = TERMINAL;
                            default:
                        }
                    }
                },
        DISPENSING(StateDuration.TRANSIENT) {
                    @Override
                    void next(VendingMachine vm) {
                        print("here is your " + vm.selection);
                        vm.amount -= vm.selection.amount();
                        vm.state = GIVING_CHANGE;
                    }
                },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
                    @Override
                    void next(VendingMachine vm) {
                        if (vm.amount > 0) {
                            print("Your change: " + vm.amount);
                            vm.amount = 0;
                        }
                        vm.state = RESTING;
                    }
                },
        TERMINAL {
                    @Override
                    void output(VendingMachine vm) {
                        print("Halted");
                    }
                };
        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(VendingMachine vm, Input input) {
            throw new RuntimeException("Only call "
                    + "next(VendingMachine vm, Input input) for non-transient"
                    + " states");
        }

        void next(VendingMachine vm) {
            throw new RuntimeException("Only call next(VendingMachine vm) for "
                    + "StateDuration.TRANSIENT states");
        }

        void output(VendingMachine vm) {
            print(vm.amount);
        }
    }

    enum MachineNo {

        MACHINE1, MACHINE2, MACHINE3
    }

    static final private EnumMap<MachineNo, VendingMachine> machines
            = new EnumMap<>(MachineNo.class);

    static {
        for (MachineNo machine : MachineNo.values()) {
            machines.put(machine, new VendingMachine());
        }
    }

    static void run(VendingMachine vm, Generator<Input> gen) {
        while (vm.state != State.TERMINAL) {
            vm.state.next(vm, gen.next());
            while (vm.state.isTransient) {
                vm.state.next(vm);
            }
            vm.state.output(vm);
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        for (MachineNo machineName : machines.keySet()) {
            System.out.println(machineName);
            gen = new FileInputGenerator(".\\src\\enums\\p10\\TestInstructions");
            run(machines.get(machineName), gen);
            System.out.println();
        }
    }
}
// For a basic sanity check:

class RandomInputGenerator implements Generator<Input> {

    @Override
    public Input next() {
        return Input.randomSelection();
    }
}
// Create Inputs from a file of ‘;’-separated strings:

class FileInputGenerator implements Generator<Input> {

    private final Iterator<String> input;

    public FileInputGenerator(String fileName) {
        input = new TextFile(fileName, ";").iterator();
    }

    @Override
    public Input next() {
        if (!input.hasNext()) {
            return null;
        }
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
