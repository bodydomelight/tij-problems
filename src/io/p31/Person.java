package io.p31;

import nu.xom.*;
import java.io.*;
import java.util.*;

public class Person {

    private String first, last, address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }
// Produce an XML Element from this Person object:

    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        Element personAddress = new Element("address");
        personAddress.appendChild(this.address);
        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(personAddress);
        return person;
    }
// Constructor to restore a Person from an XML Element:

    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        address = person.getFirstChildElement("address").getValue();
    }

    @Override
    public String toString() {
        return first + " " + last + " at " + address;
    }
// Make it human-readable:

    public static void format(OutputStream os, Document doc) throws Exception {
        Serializer serializer = new Serializer(os, "UTF-8");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(
                new Person("Dr. Bunsen", "Honeydew", "52nd Street"),
                new Person("Gonzo", "The Great", "1st Avenue"),
                new Person("Phillip J.", "Fry", "Sunset Boulevard"));
        System.out.println(people);
        Element root = new Element("people");
        for (Person p : people) {
            root.appendChild(p.getXML());
        }
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream(
                ".\\src\\io\\p31\\People.xml")), doc);
    }
}
