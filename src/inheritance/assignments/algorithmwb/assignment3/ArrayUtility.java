package inheritance.assignments.algorithmwb.assignment3;

import inheritance.assignments.algorithmwb.assignment4.NegativeNumberException;

import java.util.Scanner;

public class ArrayUtility {
    public static void enterNumberElements(int[] array){
        Scanner keyboard = new Scanner(System.in);
        String input;
        for(int i = 0; i < array.length;){
            System.out.println("Enter number " + (i + 1) + ": ");
            input = keyboard.nextLine();
            while(!StringUtility.isStringNumeric(input)){
                System.out.println("Error. non-numeric input. Enter " + (i + 1) + ": ");
                input = keyboard.nextLine();
            }
            if(isCurrentInputPositive(input, array, i)){
                i++;
            };
        }
    }

    private static boolean isCurrentInputPositive(String input, int[] array, int i) {
        //validate whether number is negative. If NegativeNumberException is not thrown, parse 'input' and assign to the array index. If not, catch
        //the exception, and decrement i to retry entering it within enterNumberElements.
        int number = Integer.parseInt(input);
        try{
            StringUtility.checkForNegativeNumber(input);
            array[i] = number;
            return true;
        } catch(NegativeNumberException e){
            System.out.println(e.getMessage());
            return false;
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }
}
