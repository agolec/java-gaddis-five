package inheritance.assignments.algorithmwb.assignment3;

import inheritance.assignments.algorithmwb.assignment4.NegativeNumberException;

import java.util.Arrays;
import java.util.Optional;

public class StringUtility {
    public static boolean isStringNumeric(String inputString){
        if(inputString.isEmpty() || inputString.isBlank()){
            return false;
        }
        try{
            Double.parseDouble(inputString);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    public static void checkForNegativeNumber(String input) throws NegativeNumberException {
        final int ZERO = 0;
        if(!isStringNumeric(input)){
            throw new IllegalArgumentException("Input must be numeric.");
        }
        double number = Double.parseDouble(input);
        if(number < ZERO){
            throw new NegativeNumberException("ERROR: Number must be positive.");
        }
    }
    public static int getIntFromString(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            System.err.println("Error: Unable to parse integer from string: " + input);
            throw new IllegalArgumentException("Invalid input: " + input);
        }

    }
}
