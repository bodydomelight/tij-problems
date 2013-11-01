package io.p31;

import java.io.File;
import nu.xom.*;
import java.util.*;

public class People extends ArrayList<Person> {

    public People(File fileName) throws Exception {
        Document doc = new Builder().build(fileName);
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {
        People p = new People(new File(".\\src\\io\\p31\\People.xml"));
        System.out.println(p);
    }
}
