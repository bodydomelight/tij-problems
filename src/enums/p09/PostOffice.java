package enums.p09;

import java.util.EnumMap;
import static net.mindview.util.Print.*;

interface MailStrategy {

    boolean handleMail(Mail m);
}

public class PostOffice {

    enum MailStrategies {

        FORWARD, GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION,
        RETURN_TO_SENDER
    }
    static EnumMap<MailStrategies, MailStrategy> mailStrategies;

    static void handle(Mail m) {
        for (MailStrategy strategy : mailStrategies.values()) {
            if (strategy.handleMail(m)) {
                return;
            }
        }
        print(m + " is a dead letter");
    }

    public static void main(String[] args) {
        mailStrategies = new EnumMap<>(MailStrategies.class);
        mailStrategies.put(MailStrategies.FORWARD, new MailStrategy() {
            @Override
            public boolean handleMail(Mail m) {
                switch (m.forwardAddress) {
                    case YES:
                        print("Forwarding " + m);
                        return true;
                    default:
                        return false;
                }
            }
        });
        mailStrategies.put(MailStrategies.GENERAL_DELIVERY, new MailStrategy() {
            @Override
            public boolean handleMail(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        print("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        });
        mailStrategies.put(MailStrategies.MACHINE_SCAN, new MailStrategy() {
            @Override
            public boolean handleMail(Mail m) {
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
        });
        mailStrategies.put(MailStrategies.VISUAL_INSPECTION, new MailStrategy() {
            @Override
            public boolean handleMail(Mail m) {
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
        });
        mailStrategies.put(MailStrategies.RETURN_TO_SENDER, new MailStrategy() {
            @Override
            public boolean handleMail(Mail m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        print("Returning " + m + " to sender");
                        return true;
                }
            }
        });

        for (Mail mail : Mail.generator(10)) {
            print(mail.details());
            handle(mail);
            print("*****");
        }
    }
}
