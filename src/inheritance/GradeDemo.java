package inheritance;

import utility.InputValidation;

import javax.swing.*;
import java.util.InputMismatchException;

public class GradeDemo {
    public static void main(String[] args) throws IllegalAccessException {
        String input = null;
        double testScore = 0;
        boolean inputValid = false;

        GradedActivity grade = new GradedActivity();

        while(!inputValid){
            input = JOptionPane.showInputDialog(null,"Enter a numeric test score 0-100:");

            try{
                testScore = Double.parseDouble(input);
                grade.setScore(testScore);
                inputValid = true;
            } catch (NumberFormatException e){
                System.err.println(e);
                System.err.println("Error: Non-numeric input entered");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.err.println("Error: Number must be between 0 and 100.");
            }
        }
        System.out.println("The grade you got is: " + grade.getGrade());

        System.exit(0);
        
    }
}
