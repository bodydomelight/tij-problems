package io.p22;

import java.util.List;

public class OSExecuteDemo {

    public static void main(String[] args) {
        List<String> list = OSExecute.command(
                "javap -classpath .\\build\\classes io.p22.OSExecuteDemo");
        for(String line : list) {
            System.out.println(line);
        }
    }
}
