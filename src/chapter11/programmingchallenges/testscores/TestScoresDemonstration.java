package chapter11.programmingchallenges.testscores;

import chapter11.TestScores;
import inheritance.assignments.algorithmwb.assignment3.StringUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestScoresDemonstration {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int UNINITIALIZED_SCORE = 0;
        int minScore = UNINITIALIZED_SCORE;
        int maxScore = UNINITIALIZED_SCORE;
        int numberOfTests;
        boolean validInput = false;
        List<Integer> tests = new ArrayList<>();
        TestScores scores = null;

        String input;
        final String MINIMUM_SCORE_PROMPT = "Enter the minimum score possible: ";
        final String MAXIMUM_SCORE_PROMPT = "Enter the maximum score possible: ";
        final String HOW_MANY_SCORES_ARE_THERE_PROMPT = "Enter the number of tests: ";

        while (!validInput) {
            try {
                if(minimumAndMaximumScoresUninitialized(minScore, UNINITIALIZED_SCORE, maxScore)){
                    // Prompt for minimum score
                    System.out.println(MINIMUM_SCORE_PROMPT);
                    input = keyboard.nextLine();
                    while (!StringUtility.isStringNumeric(input)) {
                        System.out.println(MINIMUM_SCORE_PROMPT);
                        input = keyboard.nextLine();
                    }
                    minScore = StringUtility.getIntFromString(input);

                    // Prompt for maximum score
                    System.out.println(MAXIMUM_SCORE_PROMPT);
                    input = keyboard.nextLine();
                    while (!StringUtility.isStringNumeric(input)) {
                        System.out.println(MAXIMUM_SCORE_PROMPT);
                        input = keyboard.nextLine();
                    }
                    maxScore = StringUtility.getIntFromString(input);
                }


                // Prompt for the number of tests
                System.out.println(HOW_MANY_SCORES_ARE_THERE_PROMPT);
                input = keyboard.nextLine();
                while (!StringUtility.isStringNumeric(input)) {
                    System.out.println(HOW_MANY_SCORES_ARE_THERE_PROMPT);
                    input = keyboard.nextLine();
                }
                numberOfTests = StringUtility.getIntFromString(input);

                // Clear previous test scores and collect new ones
                tests.clear();
                for (int i = 0; i < numberOfTests; i++) {
                    System.out.println("Enter the value for test " + (i + 1) + ": ");
                    input = keyboard.nextLine();
                    while (!StringUtility.isStringNumeric(input)) {
                        System.out.println("Error: Enter a numeric value");
                        input = keyboard.nextLine();
                    }
                    tests.add(StringUtility.getIntFromString(input));
                }

                // Try creating TestScores object with the user input
                scores = new TestScores(tests, minScore, maxScore);
                System.out.println(scores);

                // Mark input as valid and exit the loop if everything is correct
                validInput = true;

            } catch (InvalidTestScore e) {
                // Handle InvalidTestScore exception and prompt the user to try again
                System.out.println(e.getMessage() + ". Please try again.");

            } catch (IllegalArgumentException e) {
                // Handle other IllegalArgumentExceptions
                System.out.println("Invalid input: " + e.getMessage() + ". Please try again.");
            }
        }

        keyboard.close();
    }

    private static boolean minimumAndMaximumScoresUninitialized(int minScore, int UNINITIALIZED_SCORE, int maxScore) {
        return minScore == UNINITIALIZED_SCORE && maxScore == UNINITIALIZED_SCORE;
    }
}
