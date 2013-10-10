package io.p22;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import net.mindview.util.OSExecuteException;

public class OSExecute {

    public static List<String> command(String command) {
        boolean err = false;
        List<String> result = new ArrayList<>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;
            result.add("input:");
            while ((s = results.readLine()) != null) {
                result.add(s);
            }
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            result.add("error:");
            while ((s = errors.readLine()) != null) {
                result.add(s);
                err = true;
            }
        } catch (Exception e) {
        }
        if (err) {
            throw new OSExecuteException("Errors executing "
                    + command);
        }
        return result;
    }
}
