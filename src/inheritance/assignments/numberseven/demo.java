package inheritance.assignments.numberseven;

import javax.swing.*;

public class demo {
    public static void main(String[] args){
        boolean mailingList = false;
        String name;
        String address;
        int customerNumber;
        String phoneNumber;

        String input;

        input = JOptionPane.showInputDialog(null,"Welcome to customer creation. \nEnter your name: ");
        name = input;

        input = JOptionPane.showInputDialog(null,"Enter your street address: ");
        address = input;

        input = JOptionPane.showInputDialog(null,"Enter your customer number: ");
        customerNumber = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(null,"Enter your phone number: ");
        phoneNumber = input;

        Customer acustomer = new Customer(name,address,phoneNumber,customerNumber,true);

        JOptionPane.showMessageDialog(null,acustomer);
    }
}
