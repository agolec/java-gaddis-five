package chapter11.programmingchallenges.retailitem;

import inheritance.assignments.algorithmwb.assignment3.StringUtility;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RetailItemDemo {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String input;
        String description;
        int quantityOnHand;
        double price;

        int retailItemsCount;
        ArrayList <RetailItem> retailItems;
        boolean validData = false;

        System.out.println("Enter a number for how many items you want to create: ");

        retailItemsCount = getNumericIntegerInput(keyboard,"Enter a number for how many items you want to create");

        retailItems = new ArrayList<>();
        for(int i = 0; i < retailItemsCount; i++){
            validData = false;
            while(!validData){

                keyboard.nextLine();

                System.out.println("Enter the description: ");
                description = keyboard.nextLine();

                System.out.println("Enter the quantity: ");
                quantityOnHand = getNumericIntegerInput(keyboard,"Enter a quantity for " + (i + 1) + ": ");

                System.out.println("Enter a price for the item: ");
                price = getNumericDoubleInput(keyboard,"Enter a price for item " + (i+1) + ": ");

                try{
                    retailItems.add(new RetailItem(description,quantityOnHand,price));
                    validData = true;
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        for(int i = 0; i < retailItems.size(); i++){
            System.out.println(retailItems);
            System.out.println();
        }

        System.exit(0);

    }



    private static int getNumericIntegerInput(Scanner keyboard, String promptForInput) {
        boolean validData = false;
        int numericData = 0;
        while(!validData){
            try{
                numericData = keyboard.nextInt();
                validData = true;       //code will only ever reach here if keyboard.nextInt() doesn't throw exception.
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                System.out.println("Error: unable to get integer from scanner.");
                keyboard.next();
                System.out.println(promptForInput);
            }
        }
        return numericData;
    }
    private static double getNumericDoubleInput(Scanner keyboard, String promptForInput) {
        boolean validData = false;
        double numericData = 0;
        while(!validData){
            try{
                numericData = keyboard.nextDouble();
                validData = true;       //code will only ever reach here if keyboard.nextInt() doesn't throw exception.
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                System.out.println("Error: unable to get integer from scanner.");
                keyboard.next();
                System.out.println(promptForInput);
            }
        }
        return numericData;
    }
}
