package inheritance.assignments.algorithmwb.assignment3;

import inheritance.assignments.algorithmwb.assignment4.NegativeNumberException;

import java.util.Scanner;

public class arraySearch {
    public static void main(String[] args) {
        int[] numbers;

        String input;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the size of your array: ");
        input = keyboard.nextLine();

        while(!StringUtility.isStringNumeric(input)){
            System.out.println("Error: string was not numeric. Please enter a number: ");
            input = keyboard.nextLine();
        }
        System.out.println("You have indicated you wish to fill an array of " + input + " elements.");
        numbers = new int[Integer.parseInt(input)];

        System.out.println("Entering the numbers. . .");
        ArrayUtility.enterNumberElements(numbers);

        int targetNumber = getTargetNumber(keyboard);
        System.out.println("Searching for the number " + targetNumber + ".");
        try{
            final int NEGATIVE_ONE = -1;
            int index = NEGATIVE_ONE;
            index = ArrayAnalysis.searchForValue(numbers,targetNumber);
            System.out.println("Found the element at index: " + index);
        } catch (Exception e){
            System.out.println("Error: unable to find element.");
            System.err.println(e.getMessage());
        }


    }
    private static int getTargetNumber(Scanner keyboard){
        String input;
        while(true){
            System.out.println("Enter a numeric input to look for in the array: ");
            input = keyboard.nextLine();
            if(StringUtility.isStringNumeric(input)){
                try{
                    StringUtility.checkForNegativeNumber(input);
                    return Integer.parseInt(input);
                } catch(NegativeNumberException e){
                    System.out.println(e.getMessage());
                } catch (IllegalArgumentException e){
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("non-numeric input detected. Please enter a valid number");
            }
        }
    }
}
