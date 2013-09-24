package io.p06;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ModifiedAfterDateFinder {

    private long time;

    public ModifiedAfterDateFinder() {
    }

    public void search(String date, String regex, String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            time = sdf.parse(date).getTime();
            new ProcessFiles(new ProcessFiles.Strategy() {
                @Override
                public void process(File file) {
                    if (file.lastModified() > time) {
                        System.out.println(file.getAbsolutePath() + ";\nmodified: "
                                + new Date(file.lastModified()));
                    }
                }
            }, regex).start(args);
        } catch(ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ModifiedAfterDateFinder().search("20-09-2010", ".*\\.java", new String[]{});
    }
}
