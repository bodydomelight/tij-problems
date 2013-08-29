/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generics.p31;

interface Payable {
}

class Employee implements Payable {
}

class Hourly extends Employee implements Payable {
}

public class MultipleInterfaceVariants {

    public static void main(String[] args) {
        Employee e = new Employee();
        Hourly h = new Hourly();
    }
}