package io.p33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PrefsDemo {

    public static void main(String[] args) throws IOException, BackingStoreException {
        Preferences pref = Preferences.userNodeForPackage(PrefsDemo.class);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String val;
            do {
                System.out.println("\"base directory\" current value: " + pref.get("base directory", "null"));
                System.out.print("Set \"base directory\" value ('!q' to quit): ");
                val = br.readLine();
                if (!"!q".equals(val)) {
                    pref.put("base directory", val);
                }
            } while (!"!q".equals(val));
        }
        pref.removeNode();
    }
}
