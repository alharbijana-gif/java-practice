package oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Demonstrates inheritance, abstract classes, polymorphism, interfaces and exceptions. */
public class OopDemo {
    public static void main(String[] args) {
        // Polymorphism: one list, different shape types
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Triangle(3, 4, 5));
        Collections.sort(shapes); // uses Comparable (compares by area)
        System.out.println("Shapes sorted by area:");
        for (Shape s : shapes) System.out.println("  " + s);

        // Input validation with exceptions
        try {
            new Circle(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Inheritance and method overriding
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("Sara", 1000, 0.03));
        accounts.add(new CheckingAccount("Lina", 200, 100));
        for (BankAccount acc : accounts) {
            try {
                acc.withdraw(250);
                System.out.println("Withdrew 250 -> " + acc);
            } catch (InsufficientFundsException e) {
                System.out.println("Failed for " + acc.getOwner() + ": " + e.getMessage());
            }
        }
        ((SavingsAccount) accounts.get(0)).addInterest();
        System.out.println(accounts.get(0));
    }
}
