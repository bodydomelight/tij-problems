package enums.p08;

import static net.mindview.util.Print.*;

public class PostOffice {

    enum MailHandler {

        FORWARD {
                    @Override
                    boolean handle(Mail m) {
                        switch (m.forwardAddress) {
                            case YES:
                                print("Forwarding " + m);
                                return true;
                            default:
                                return false;
                        }
                    }
                },
        GENERAL_DELIVERY {
                    @Override
                    boolean handle(Mail m) {
                        switch (m.generalDelivery) {
                            case YES:
                                print("Using general delivery for " + m);
                                return true;
                            default:
                                return false;
                        }
                    }
                },
        MACHINE_SCAN {
                    @Override
                    boolean handle(Mail m) {
                        switch (m.scannability) {
                            case UNSCANNABLE:
                                return false;
                            default:
                                switch (m.address) {
                                    case INCORRECT:
                                        return false;
                                    default:
                                        print("Delivering " + m + " automatically");
                                        return true;
                                }
                        }
                    }
                },
        VISUAL_INSPECTION {
                    @Override
                    boolean handle(Mail m) {
                        switch (m.readability) {
                            case ILLEGIBLE:
                                return false;
                            default:
                                switch (m.address) {
                                    case INCORRECT:
                                        return false;
                                    default:
                                        print("Delivering " + m + " normally");
                                        return true;
                                }
                        }
                    }
                },
        RETURN_TO_SENDER {
                    @Override
                    boolean handle(Mail m) {
                        switch (m.returnAddress) {
                            case MISSING:
                                return false;
                            default:
                                print("Returning " + m + " to sender");
                                return true;
                        }
                    }
                };

        abstract boolean handle(Mail m);
    }

    static void handle(Mail m) {
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handle(m)) {
                return;
            }
        }
        print(m + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            print(mail.details());
            handle(mail);
            print("*****");
        }
    }
}
