package io.p33;

import java.util.prefs.Preferences;

public class PrefsDemo {
    public static void main(String[] args) {
        Preferences pref = Preferences.userNodeForPackage(PrefsDemo.class);
    }
}
